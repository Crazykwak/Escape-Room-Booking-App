package com.crazykwak.roombooking.member.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table (name = "member")
@Entity
@Getter @Setter
@NoArgsConstructor
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private String userId;
    private String password;
    private String email;
    private String local;

    @Column(name = "phone_num")
    private String phoneNum;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_grade")
    private MemberGrade memberGrade;

    public Member(String userId, String password, String email, String local, String phoneNum, MemberGrade memberGrade) {
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.local = local;
        this.phoneNum = phoneNum;
        this.memberGrade = memberGrade;
    }
}
