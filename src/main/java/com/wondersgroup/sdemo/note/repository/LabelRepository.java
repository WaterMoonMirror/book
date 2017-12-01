package com.wondersgroup.sdemo.note.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wondersgroup.sdemo.note.bean.BookBean;
import com.wondersgroup.sdemo.note.bean.LabelBean;

public interface LabelRepository extends JpaRepository<LabelBean, Integer>  {

}
