/**
 * 
 */
package gorest.pomEndpoints;

/**
 * @author intelligent
 *
 */
public class Routes {

	private Routes() {


	}


	public static final String BASE_URL = "https://gorest.co.in/public/v2";

	/**
	 * @return the postUrl
	 */
	public static String getPostUrl() {
		return postUrl;
	}

	/**
	 * @param postUrl the postUrl to set
	 */
	public static void setPostUrl(String postUrl) {
		Routes.postUrl = postUrl;
	}

	/**
	 * @return the getUrl
	 */
	public static String getGetUrl() {
		return getUrl;
	}

	/**
	 * @param getUrl the getUrl to set
	 */
	public static void setGetUrl(String getUrl) {
		Routes.getUrl = getUrl;
	}

	/**
	 * @return the updateUrl
	 */
	public static String getUpdateUrl() {
		return updateUrl;
	}

	/**
	 * @param updateUrl the updateUrl to set
	 */
	public static void setUpdateUrl(String updateUrl) {
		Routes.updateUrl = updateUrl;
	}

	/**
	 * @return the deleteUrl
	 */
	public static String getDeleteUrl() {
		return deleteUrl;
	}

	/**
	 * @param deleteUrl the deleteUrl to set
	 */
	public static void setDeleteUrl(String deleteUrl) {
		Routes.deleteUrl = deleteUrl;
	}


	// user module endpoints
	private static String postUrl = BASE_URL + "/users";

	private static String getUrl = BASE_URL + "/users/{id}";

	private static String updateUrl = BASE_URL + "/users/{id}";

	private static String deleteUrl = BASE_URL + "/users/{id}";




}
