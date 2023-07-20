package com.group.libraryapp.service.book;

import com.group.libraryapp.domain.book.Book;
import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.repository.user.UserRepository;
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory;
import com.group.libraryapp.repository.user.UserLoanHistoryRepository;
import com.group.libraryapp.dto.book.BookCreateRequest;
import com.group.libraryapp.dto.book.BookLoanRequest;
import com.group.libraryapp.dto.book.BookReturnRequest;
import com.group.libraryapp.repository.book.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final UserLoanHistoryRepository userLoanHistoryRepository;
    private final UserRepository userRepository;
    public BookService(BookRepository bookRepository,
                       UserLoanHistoryRepository userLoanHistoryRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userLoanHistoryRepository = userLoanHistoryRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveBook(BookCreateRequest request) {
        bookRepository.save(new Book(request.getName()));
    }

    @Transactional
    public void loanBook(BookLoanRequest request) {
        // 1. 책 정보를 가져온다.
        Book book = bookRepository.findByName(request.getBookName())
                .orElseThrow(IllegalArgumentException::new);
        // 2. 대출기록 정보 확인해서 대출중인지 확인
        // 3. 대출중이라면 예외 발생
        if (userLoanHistoryRepository.existsByBookNameAndIsReturn(book.getName(), false)) {
            throw new IllegalArgumentException("진작 대출되어 있는 책입니다.");
        }
        // 4. 유저 정보를 가져온다.
        User user = userRepository.findByName(request.getUserName())
                .orElseThrow(IllegalArgumentException::new);
        user.loanBook(book.getName());

    }

    @Transactional
    public void returnBook(BookReturnRequest request) {
        // 1. 유저 찾기
        User user = userRepository.findByName(request.getUserName())
                .orElseThrow(IllegalArgumentException::new);
        System.out.println("안녕하세요");
        // 2. 대출 기록 찾기
        user.returnBook(request.getBookName());

        // userLoanHistoryRepository.save(history);
        // 영속성컨텍스트에서 가져온 userLoanHistory 객체의 변경을 감지했다가 반영

    }
}
