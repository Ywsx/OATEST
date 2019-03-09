package hrm.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import static hrm.util.common.HrmConstants.DEPTTABLE;
import hrm.dao.provider.DeptDynaSqlProvider;
import hrm.domain.Dept;

public interface DeptDao {
	@SelectProvider(type=DeptDynaSqlProvider.class,method="selectWhitPAram")
	List<Dept> selectByPage(Map<String,Object> params);
	@SelectProvider(type=DeptDynaSqlProvider.class,method="count")
	Integer count(Map<String,Object> params);
	@Select("select * from"+DEPTTABLE+" ")
	List<Dept> selectAllDept();
	@Select("select * from"+DEPTTABLE+"where id = #{id}")
	Dept selectById(int id);
	@Delete("delete from"+DEPTTABLE+"where id = #{id}")
	void deleteById(Integer id);
	@SelectProvider(type=DeptDynaSqlProvider.class,method="insertDept")
	void save(Dept dept);
	@SelectProvider(type=DeptDynaSqlProvider.class,method="updateDept")
	void update(Dept dept);
	
}
