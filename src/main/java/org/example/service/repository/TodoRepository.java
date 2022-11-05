package org.example.service.repository;

import org.example.model.TodoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoModel, Long> {
}
//DB와 데이터를 주고받기 위한 인터페이스를 정의한 부분
//실질적인 데이터 저장소가 아닌 데이터를 주고받기 위한 인터페이스 -> Entity Repository만 만들면 된다
//JpaRepository<DB와 연결될 객체, 해당 객체의 id의 필드타입>
