package kr.co.ezenac.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import kr.co.ezenac.beans.BoardInfoBean;

//쿼리문(마이바티스) 부분
public interface TopMenuMapper {
	
	@Select("select board_info_idx,board_info_name from board_info_table order by board_info_idx")
	List<BoardInfoBean> getTopMenuList();
}
