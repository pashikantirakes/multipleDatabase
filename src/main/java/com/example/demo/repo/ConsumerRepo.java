package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.consumer.Consumer;


public interface ConsumerRepo extends JpaRepository<Consumer, Integer> {

}
