package com.example.mongoss;

import com.example.mongoss.model.Todo;
import com.example.mongoss.repo.TodoRepo;
import com.example.mongoss.repo.TodoRepoImplementation;
import com.example.mongoss.repo.TodoRepocustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/todod")
public class TodoController {
    private    TodoRepoImplementation todoRepoImplementation;
    private TodoRepocustom todoRepocustom;
    private TodoRepo todo;z
    @Autowired
    public  TodoController(TodoRepoImplementation todoRepoImplementation,TodoRepocustom todoRepocustom){
        this.todoRepoImplementation=todoRepoImplementation;
        this.todoRepocustom = todoRepocustom;

    }


    @GetMapping()
    public List<Todo> getall(){
        List<Todo> datas = new ArrayList<Todo>();

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Todo> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Todo todo) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Todo> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Todo> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Todo get(int index) {
                return null;
            }

            @Override
            public Todo set(int index, Todo element) {
                return null;
            }

            @Override
            public void add(int index, Todo element) {

            }

            @Override
            public Todo remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Todo> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Todo> listIterator(int index) {
                return null;
            }

            @Override
            public List<Todo> subList(int fromIndex, int toIndex) {
                return null;
            }
        }
        return
    }


}
