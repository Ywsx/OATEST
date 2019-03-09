package hrm.dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import static hrm.util.common.HrmConstants.EMPLOYEETABLE;
import hrm.domain.Employee;

public class EmployeeDynaSqlProvider {
	public String selectWhitParam(final Map<String,Object> params){
		String sql = new SQL(){
			{
				SELECT("*");
				FROM(EMPLOYEETABLE);
				if(params.get("employee") != null){
					Employee employee = (Employee) params.get("employee");
					if(employee.getDept() != null && employee.getDept().getId() !=
							null && employee.getDept().getId() != 0){
						WHERE("dept_id = #{employee.dept.id}");
					}
					if(employee.getJob() != null && employee.getJob().getId() !=
							null && employee.getJob().getId() != 0){
						WHERE("job_id = #{employee.job.id}");
					}
					if(employee.getName() != null && !employee.getName().equals("")){
						WHERE("name LIKE CONCAT('%',#{employee.name},'%')");
					}
					if(employee.getPhone() != null && !employee.getName().equals("")){
						WHERE("phone LIKE CONCAT('%',#{employee.phone},'%')");
					}
					if(employee.getCardId() != null && !employee.getCardId().equals("")){
						WHERE("card_id LIKE CONCAT('%',#{employee.cardID},'%')");
					}
					if(employee.getSex() != null && employee.getSex() !=0){
						WHERE("sex = #{employee.sex}");
					}
				}
			}
		}.toString();
		if(params.get("pageModel") != null){
			sql += "limit #{pageModel.firstLimitParam},#{pageModel.pageSize}";
		}
		return sql;
	}
	//动态查询总数量
	public String count(final Map<String, Object> params){
		return new SQL(){
			{
				SELECT("count(*)");
				FROM(EMPLOYEETABLE);
				if(params.get("employee") != null){
					Employee employee = (Employee)params.get("employee");
					if(employee.getDept() != null && employee.getDept().getId() != null
							&& employee.getDept().getId() != 0){
						WHERE(" dept_id = #{employee.dept.id}");
					}
					if(employee.getJob() != null && employee.getJob().getId() !=
							null && employee.getJob().getId() != 0){
						WHERE("job_id = #{employee.job.id}");
					}
					if(employee.getName() != null && !employee.getName().equals("")){
						WHERE("name LIKE CONCAT('%',#{employee.name},'%')");
					}
					if(employee.getPhone() != null && !employee.getName().equals("")){
						WHERE("phone LIKE CONCAT('%',#{employee.phone},'%')");
					}
					if(employee.getCardId() != null && !employee.getCardId().equals("")){
						WHERE("card_id LIKE CONCAT('%',#{employee.cardID},'%')");
					}
					if(employee.getSex() != null && employee.getSex() !=0){
						WHERE("sex = #{employee.sex}");
					}
				}
			}
		}.toString();
	}
	//動態
	public String insertEmployee(final Employee employee){
		return new SQL(){
			{
				INSERT_INTO(EMPLOYEETABLE);
				if(employee.getName() != null){
					VALUES("name","#{name}");
				}
				if(employee.getCardId() != null){
					VALUES("card_id","#{name}");
				}
				if(employee.getAddress() != null){
					VALUES("address","#{address}");
				}
				if(employee.getPostCode() != null){
					VALUES("post_code","#{postCode}");
				}
				if(employee.getTel() != null){
					VALUES("tel","#{tel}");
				}
				if(employee.getPhone() != null){
					VALUES("phone","#{phone}");
				}
				if(employee.getQqNum() != null){
					VALUES("qq_num","@{qqNum}");
				}
				if(employee.getEmail() != null){
					VALUES("email","#{email}");
				}
				if(employee.getSex() != null){
					VALUES("sex","#{sex}");
				}
				if(employee.getParty() != null){
					VALUES("party","#{paty}");
				}
				if(employee.getBirthday() != null){
					VALUES("birthday","#{birthday}");
				}
				if(employee.getRace() != null){
					VALUES("race","#{race}");
				}
				if(employee.getEducation() != null){
					VALUES("education","#{education}");
				}
				if(employee.getSpeciality() != null){
					VALUES("speciality","#{speciality}");
				}
				if(employee.getHobby() != null){
					VALUES("hobby","#{hobby}");
				}
				if(employee.getRemark() != null){
					VALUES("remark","#{remark}");
				}
				if(employee.getCreateDate() != null){
					VALUES("create_date","#{createDate}");
				}
				if(employee.getDept() != null){
					VALUES("dept_id","#{dept.id}");
				}
				if(employee.getJob() != null){
					VALUES("job_id","#{job.id}");
				}
			}
		}.toString();
	}
	//更新
	public String updateEmployee(final Employee employee){
		return new SQL(){
			{
				UPDATE(EMPLOYEETABLE);
				if(employee.getName() != null){
					SET("name","#{name}");
				}
				if(employee.getCardId() != null){
					SET("card_id","#{name}");
				}
				if(employee.getAddress() != null){
					SET("address","#{address}");
				}
				if(employee.getPostCode() != null){
					SET("post_code","#{postCode}");
				}
				if(employee.getTel() != null){
					SET("tel","#{tel}");
				}
				if(employee.getPhone() != null){
					SET("phone","#{phone}");
				}
				if(employee.getQqNum() != null){
					SET("qq_num","@{qqNum}");
				}
				if(employee.getEmail() != null){
					SET("email","#{email}");
				}
				if(employee.getSex() != null){
					SET("sex","#{sex}");
				}
				if(employee.getParty() != null){
					SET("party","#{paty}");
				}
				if(employee.getBirthday() != null){
					SET("birthday","#{birthday}");
				}
				if(employee.getRace() != null){
					SET("race","#{race}");
				}
				if(employee.getEducation() != null){
					SET("education","#{education}");
				}
				if(employee.getSpeciality() != null){
					SET("speciality","#{speciality}");
				}
				if(employee.getHobby() != null){
					SET("hobby","#{hobby}");
				}
				if(employee.getRemark() != null){
					VALUES("remark","#{remark}");
				}
				if(employee.getCreateDate() != null){
					VALUES("create_date","#{createDate}");
				}
				if(employee.getDept() != null){
					VALUES("dept_id","#{dept.id}");
				}
				if(employee.getJob() != null){
					VALUES("job_id","#{job.id}");
				}
			}
		}.toString();
	}
}
