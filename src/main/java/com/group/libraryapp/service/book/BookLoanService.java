//package com.group.libraryapp.service.book;
//
//import com.group.libraryapp.domain.book.Book;
//import com.group.libraryapp.dto.book.BookCreateRequest;
//import com.group.libraryapp.repository.book.BookLoanRepository;
//import com.group.libraryapp.repository.book.BookRepository;
//import org.springframework.transaction.annotation.Transactional;
//
//public class BookLoanService {
//    private final BookLoanRepository bookLoanRepository;
//
//    public BookLoanService(BookLoanRepository bookLoanRepository) {
//        this.bookLoanRepository = bookLoanRepository;
//    }
//
//    @Transactional
//    public void loanBook() {
//
//    }
//}

/*
public class BookService {

    private final BookRepository bookRepository;
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public void saveBook(BookCreateRequest request) {
        bookRepository.save(new Book(request.getName()));
    }
}*/
