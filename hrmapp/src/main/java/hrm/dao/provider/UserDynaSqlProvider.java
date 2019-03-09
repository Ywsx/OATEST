package hrm.dao.provider;

import hrm.domain.User;

import java.util.Map;

import static hrm.util.common.HrmConstants.USERTABLE;

import org.apache.ibatis.jdbc.SQL;

public class UserDynaSqlProvider {


	public String selectWhitParam(final Map<String,Object> params){
		String sql = new SQL(){
			{
				SELECT("*");
				FROM(USERTABLE);
				if(params.get("user")!=null){
					User user = (User)params.get("user");
					if(user.getUsername() != null && !user.getUsername().equals("")){
						WHERE(" username LIKE COUCAT ('%',#(user.username),'%')");
					}
					if(user.getStatus() != null & !user.getStatus().equals("")){
						WHERE(" status LIKE COUCAT('%',#{user.status},'%')");
					}
				}
			}
		}.toString();
		if(params.get("pageModel") != null){
			sql += "limit #{pageModel.firstLimitParam},#{pageModel.pageSize} ";
		}
		return sql;
	}
	//动态插入
	public String insertUser(final User user){
		return new SQL(){
			{
				INSERT_INTO(USERTABLE);
				if(user.getUsername() != null && !user.getUsername().equals("")){
					VALUES("username","#{username}");
				}
				if(user.getStatus() != null && !user.getStatus().equals("")){
					VALUES("status","#{status}");
				}
				if(user.getLoginname() != null && !user.getLoginname().equals("")){
					VALUES("loginname","#{loginname}");
				}
				if(user.getPassword() != null && !user.getPassword().equals("")){
					VALUES("password","#{password}");
				}
			}	
		}.toString();
	}
	//动态查询总数
	public String count( final Map<String,Object> params){
		return new SQL(){
			{
				SELECT("count(*)");
				FROM(USERTABLE);
				if(params.get("user") != null){
					User user = (User)params.get("user");
					if(user.getUsername() != null && !user.getUsername().equals("")){
						WHERE("username LIKE CONCAT('%',#{user.username},'%')");
					}
					if(user.getStatus() != null && !user.getStatus().equals("")){
						WHERE("username LIKE CONCAT('%',#{user.statis},'%')");
					}
				}
			}
		}.toString();
	}
	//动态更新
	public String updateUser(final User user){
		return new SQL(){
			{
				UPDATE(USERTABLE);
				if(user.getUsername() != null){
					SET("username = #{username}");
				}
				if(user.getLoginname() != null){
					SET("loginname = #{loginname}");
				}
				if(user.getLoginname() != null){
					SET("status = #{status}");
				}
				if(user.getCreatedate() != null){
					SET("create_date = #{createDate}");
				}
				WHERE("id = #{id}");
			}
		}.toString();
	}
}
