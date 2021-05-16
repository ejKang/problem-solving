package com.joo.book.springboot.springbootwebservice.domain;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

@Getter
@MappedSuperclass // 클래스를 상속 받을 경우 해당 클래스의 필드들도 entity의 칼럼으로 인식하도록 설정
@EntityListeners(AuditingEntityListener.class) // auditing 기능을 포함 
public abstract class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
