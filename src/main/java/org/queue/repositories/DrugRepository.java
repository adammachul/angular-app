package org.queue.repositories;

import org.queue.models.Drug;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DrugRepository extends PagingAndSortingRepository<Drug, String> {
}
