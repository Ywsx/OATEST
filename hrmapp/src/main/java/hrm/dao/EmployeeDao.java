package hrm.dao;

import static hrm.util.common.HrmConstants.EMPLOYEETABLE;
import hrm.dao.provider.EmployeeDynaSqlProvider;
import hrm.domain.Employee;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;

import org.apache.ibatis.mapping.FetchType;

public interface EmployeeDao {
	@SelectProvider(type=EmployeeDynaSqlProvider.class,method="count")
	Integer count(Map<String,Object> params);
	//根据数据动态查询员工
	@SelectProvider(type=EmployeeDynaSqlProvider.class,method="selectWhitParam")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="card_id",property="cardId"),
		@Result(column="post_code",property="postCode"),
		@Result(column="qq_num",property="qqNum"),
		@Result(column="birthday",property="birthday",javaType=java.util.Date.class),
		@Result(column="create_date",property="createDate",javaType=java.util.Date.class),
		@Result(column="dept_id",property="dept",
				one=@One(select="org.fkit.hrm.dao.DeptDao.selectById",
				fetchType=FetchType.EAGER)),
		@Result(column="job_id",property="job",
				one=@One(select="org.fkit.hrm.dao.JobDao.selectById",
				fetchType=FetchType.EAGER))
	})
	List<Employee> selectByPage(Map<String,Object> params);
	//动态插入员工
	@SelectProvider(type=EmployeeDynaSqlProvider.class,method="insertEmployee")
	void save(Employee employee);
	//根据员工id删除员工
	@Delete("delete from"+EMPLOYEETABLE+"where id =#{id}")
	void deleteById(Integer id);
	//根据id查询员工
	@Select("select * form"+EMPLOYEETABLE+"where id = #{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="card_id",property="cardId"),
		@Result(column="post_code",property="postCode"),
		@Result(column="qq_num",property="qqNum"),
		@Result(column="birthday",property="birthday",javaType=java.util.Date.class),
		@Result(column="create_date",property="cteateDate",javaType=java.util.Date.class),
		@Result(column="dept_date",property="dept",
				one=@One(select="org.fkit.hrm.dao.JobDao.selectById",
				fetchType=FetchType.EAGER)),
		@Result(column="job_id",property="job",
				one=@One(select="org.",
				fetchType=FetchType.EAGER))
	})
	Employee selectById(Integer id);
	@SelectProvider(type=EmployeeDynaSqlProvider.class,method="updateEmployee")
	void update(Employee employee);
	
}
