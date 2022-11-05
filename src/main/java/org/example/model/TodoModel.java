package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
//@Getter / @Setter, @ToString, @EqualsAndHashCode와 @RequiredArgsConstructor 사용가능
//callSuper, includeFieldName, exclude와 같은 파라미터와 같이 사용될 수 없으므로, 해당 파라미터 사용이 필요할 때는 개별 어노테이션을 따로 다 명시해주면 되겠다.
@Entity
// 데이타베이스의 테이블과 일대일로 매칭되는 객체 단위
@NoArgsConstructor
//파라미터가 없는 기본 생성자를 생성
@AllArgsConstructor
//클래스에 존재하는 모든 필드에 대한 생성자를 자동으로 생성한다.
public class TodoModel { // 실제 DB와 연관된 클래스
    @Id
    //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //기본 키를 자동 생성해주는 어노테이션
    private Long id;

    @Column(nullable = false)
    //데이타베이스의 테이블에 있는 컬럼과 동일하게 1:1로 매칭되기 때문에 Entity 클래스안에 내부변수로 정의
    private String title;

    //order 키워드는 H2 DB에서 예약어로 사용-> name을 새로 지정
    @Column(name = "todoOrder", nullable = false)
    private Long order;

    @Column(nullable = false)
    private Boolean completed;

}