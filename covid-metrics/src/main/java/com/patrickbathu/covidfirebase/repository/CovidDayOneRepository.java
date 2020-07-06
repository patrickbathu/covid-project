package com.patrickbathu.covidfirebase.repository;

import com.patrickbathu.covidfirebase.dto.CovidDayOne;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CovidDayOneRepository extends MongoRepository<CovidDayOne, String> {
}
