package com.weme.webservice.api;

import com.weme.webservice.domain.Animal;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

//Animal 저장
@Service
public interface AnimalRepository extends PagingAndSortingRepository<Animal,String> {
}
