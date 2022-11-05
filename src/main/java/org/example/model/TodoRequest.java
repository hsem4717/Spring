package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoRequest { // DB 요청과 관련된 클래스

    private String title;
    private Long order;
    private Boolean completed;

}
