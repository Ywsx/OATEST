package hrm.dao;

import static hrm.util.common.HrmConstants.JOBTABLE;

import java.util.List;
import java.util.Map;

import hrm.dao.provider.JobDynaSqlProvider;
import hrm.domain.Job;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
public interface JobDao {
	@Select("select * from"+JOBTABLE+ "where id = #{id}")
	Job selectById(int id);
	@Select("select * from"+JOBTABLE+ "")
	List<Job> selectAllJob();
	@SelectProvider(type=JobDynaSqlProvider.class,method="selectWhitParam")
	List<Job> selectByPage(Map<String, Object> params);
	@SelectProvider(type=JobDynaSqlProvider.class,method="count")
	Integer count(Map<String,Object> params);
	@Delete("delete from"+JOBTABLE+"where id = #{id}")
	void deleteById(Integer id);
	@SelectProvider(type=JobDynaSqlProvider.class,method="insertJob")
	void save(Job job);
	@SelectProvider(type=JobDynaSqlProvider.class,method="updateJob")
	void update(Job job);
}
