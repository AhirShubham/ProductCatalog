package com.shubham.springboot.productcatalog.services;

import com.shubham.springboot.productcatalog.Repositories.ProductRepo;
import com.shubham.springboot.productcatalog.dtos.SortParam;
import com.shubham.springboot.productcatalog.dtos.SortType;
import com.shubham.springboot.productcatalog.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class JpaSearchService implements ISearchService{
    @Autowired
    private ProductRepo productRepo;

    @Override
    public Page<Product> searchProducts(String query, Integer pageNumber, Integer pageLimit, List<SortParam> sortParamList) {
        //Sort sort = Sort.by("price").and(Sort.by("id").descending());
        Sort sort=null;
        if(!sortParamList.isEmpty()){

            sort=sortParamList.get(0).getSortType().equals(SortType.ASC)?Sort.by(sortParamList.get(0).getParamName()):Sort.by(sortParamList.get(0).getParamName()).descending();

            for(int i=1;i<sortParamList.size();i++){
                sort=sortParamList.get(i).getSortType().equals(SortType.ASC)?sort.and(Sort.by(sortParamList.get(i).getParamName())):sort.and(Sort.by(sortParamList.get(i).getParamName()).descending());
            }
        }
        return productRepo.findProductsByName(query,PageRequest.of(pageNumber,pageLimit,sort));
    }
}
