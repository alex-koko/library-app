package com.group.libraryapp.domain.user.loanhistory;

import com.group.libraryapp.domain.user.User;
import jakarta.persistence.Entity;

import jakarta.persistence.*;

@Entity
public class UserLoanHistory {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @ManyToOne
    private User user;
    // 대출 기록은 여러개, 대출 기록을 소유하고 있는 사용자는 한 명

    private String bookName;

    private boolean isReturn;

    public UserLoanHistory(User user, String bookName) {
        this.user = user;
        this.bookName = bookName;
        this.isReturn = false;
    }

    protected UserLoanHistory() {
        // jpa 기본 생성자
    }

    public void doReturn() {
        this.isReturn = true;
    }

    public String getBookName() {
        return this.bookName;
    }
}
