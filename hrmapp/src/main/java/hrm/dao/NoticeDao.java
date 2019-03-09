package hrm.dao;

import hrm.domain.Notice;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import static hrm.util.common.HrmConstants.NOTICETABLE;
public interface NoticeDao {
	//動態查詢
	@SelectProvider(type=NoticeDynaSqlProvider.class,method="selectWhitParam")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="create_date",property="createDate",javaType=java.util.Date.class),
		@Result(column="user_id",property="user",
		one=@One(select="",fetchType=FetchType.EAGER))
	})
	List<Notice> selectByPage(Map<String,Object> params);
	//
	@SelectProvider(type=NoticeDynaSqlProvider.class,method="count")
	Integer count(Map<String,Object> params);
	@Select("select * from "+NOTICETABLE+"where id = #{id}")
	Notice selectById(int id);
	@Delete("delete from "+NOTICETABLE+"where id = #{id}")
	void deleteById(Integer id);
	@SelectProvider(type=NoticeDynaSqlProvider.class,method="insertNotice")
	void save(Notice notice)
	@SelectProvider(type=NoticeDynaSqlProvicer.class,method="updateNotice")
	void update(Notice notice);
}
