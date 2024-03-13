package ag.selm.catalogue.repository;


import ag.selm.catalogue.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Integer> {
//    написание собственных запросов - фильтрация по названию

//    первый способ
    // аналог select * from catalogue.t_product where c_title ilike :filter
//    Iterable<Product> findAllByTitleLikeIgnoreCase(String filter);

//    второй способ jpql-запрос
//    @Query(value = "select p from Product p where p.title ilike :filter")
//    Iterable<Product> findAllByTitleLikeIgnoreCase(@Param("filter") String filter);

    //третий способ нативный запрос на sql
//    @Query(value = "select * from catalogut.t_product where c_title ilike :filter", nativeQuery = true)
//    Iterable<Product> findAllByTitleLikeIgnoreCase(@Param("filter") String filter);
//    четвертый способ через класс Product
@Query(name = "Product.findAllByTitleLikeIgnoringCase", nativeQuery = true)
Iterable<Product> findAllByTitleLikeIgnoreCase(@Param("filter") String filter);
}
