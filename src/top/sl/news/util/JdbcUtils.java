package top.sl.news.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;

/**
 * ��װ���õĲ���
 * @author Jie.Yuan
 *
 */
public class JdbcUtils {

	// ��ʼ�����ӳ�
	private static DataSource dataSource;
	static {
		dataSource = new ComboPooledDataSource();
	}
	
	public static DataSource getDataSource() {
		return dataSource;
	}
	
	/**
	 * ����DbUtils���ù��������
	 */
	public static QueryRunner getQuerrRunner() {
		return new QueryRunner(dataSource);
	}
}








