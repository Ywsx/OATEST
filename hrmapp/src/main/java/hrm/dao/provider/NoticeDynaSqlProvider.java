package hrm.dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import hrm.domain.Notice;

public class NoticeDynaSqlProvider {
	public String selectWhitParam(Map<String,Object> params){
		String sql = new SQL(){
			{
				SELECT("*");
				FROM(NOTICETABLE);
				if(params.get("notice") != null){
					Notice notice = (Notice) params.get("notice");
					if(notice.getTitle() != null && !notice.getTitle().equals("")){
						WHERE("title LIKE CONCAT('%',#{notice.title},'%')");
					}
					if(notice.getContent() != null && !notice.getContent().equals("")){
						WHERE("content LIKE CONCAT('%',#{notice.content},'%')");
					}
				}
			}
		}.toString();
		if(params.get("pageModel") != null){
			sql += "limit #{pageModel.firstLimitParam},#{pageModel.pageSize}";
		}
		return sql;
	}
	//動態查詢總數量
	public String count(Map<String,Object> params){
		return new SQL(){
			{
				SELECT("count(*)");
				FROM(NOTICETABLE);
				if(params.get("notice") != null){
					Notice notice = (Notice)params.get("notice");
					if(notice.getTitle() != null && !notice.getTitle().equals("")){
						WHERE("title LIKE CONCAT('%',#{notice.title},'%')");
					}
				}
		
			}
		}.toString();
	}
	//動態插入
	public String insertNotice(Notice notice){
		return new SQL(){
			{
				INSERT_INTO(NOTICETABLE);
				if(notice.getTitle() != null && notice.getTitle().equals("")){
					VALUES("title","{title}");
				}
				if(notice.getUser() != null && notice.getUser().getId() != null){
					VALUES("user_id","#{user.id}");
				}
			}
		}.toString();
	}
	//動態更新
	public String updateNotice(Notice notice){
		return new SQL(){
			{
				UPDATE(NOTICETABLE);
					if(notice.getTitle()!=null && !notice.getTitle().equals("")){
						SET("title = #{title}");
					}
					if(notice.getContent() != null && notice.getContent().equals("")){
						SET("user_id = #{user.id}");
					}
					if(notice.getUser() != null && notice.getUser.getId() != null){
						SET("user_id = #{user.id}");
					}
					 WHERE("id = #{id}");		
			}
		}.toString();
	}
}
