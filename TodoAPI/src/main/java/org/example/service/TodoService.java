package org.example.service;

import lombok.AllArgsConstructor;
import org.example.model.TodoModel;
import org.example.model.TodoRequest;
import org.example.service.repository.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
//해당 클래스가 비즈니스 로직을 담은 Service 클래스임을 명시
@AllArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    // 1 todo 리스트 목록에 아이템을 추가
    public TodoModel add(TodoRequest request){
        TodoModel todoModel = new TodoModel();
        todoModel.setTitle(request.getTitle());
        todoModel.setOrder(request.getOrder());
        todoModel.setCompleted(request.getCompleted());
        // <S extends T> S save(S entity);
        // save는 제네릭으로 받은 타입(T)으로 값을 반환
        return this.todoRepository.save(todoModel);
    }
    // 2 todo 리스트 목록 중 특정 아이템을 조회
    public TodoModel searchById(Long id){
        return this.todoRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    // 3 todo 리스트 전체 목록을 조회
    public List<TodoModel> searchAll(){
        return this.todoRepository.findAll();
    }
    // 4 todo 리스트 목록 중 특정 아이템을 수정
    public TodoModel updateById(Long id, TodoRequest request){
        TodoModel todoModel = this.searchById(id);
        if(request.getTitle() != null){
            todoModel.setTitle(request.getTitle());
        }
        if(request.getOrder() != null){
            todoModel.setOrder(request.getOrder());
        }
        if(request.getCompleted() != null){
            todoModel.setCompleted(request.getCompleted());
        }
        return this.todoRepository.save(todoModel);
    }
    // 5 todo 리스트 목록 중 특정 아이템을 삭제
    public void deleteById(Long id){
        this.todoRepository.deleteById(id);
    }
    // 6 todo 리스트 전체 목록을 삭제
    public void deleteAll(){
        this.todoRepository.deleteAll();
    }
}
