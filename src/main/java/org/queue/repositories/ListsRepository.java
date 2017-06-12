package org.queue.repositories;

import org.queue.models.Lists;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

@Repository
public interface ListsRepository extends JpaRepository<Lists, String> {

    //@PreAuthorize("#lists?.user == null or #lists?.user?.name == authentication?.username")
    //Lists save(@Param("lists") Lists lists);
}
