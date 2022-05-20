import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * test Fallabella
 * @author Ricardo Diaz
 */
public class Demo {
    /**
     * Test1 Happy case
     */
    @Test(priority = 2)
    public void testGetUsers(){
        baseURI = "https://gorest.co.in/public/v2";

       String body = given()
                     .when()
                          .get("/users")
                     .then()
                        .statusCode(200)
                        .body("name[0]", equalTo("Niro Rana LLD"))
                        .extract().body().asString();

       System.out.println(body);
    }
@Test(priority = 3)
/**
 * Test Case User OK
 */
    public void testPUser(){
        baseURI = "https://gorest.co.in/public/v2";

        Map<String, Object> map = new HashMap<String,Object>();
        map.put("id","3666");
        map.put("name","Pedro");
        map.put("email","Pedro@gmail.com");
        map.put("gender","male");

        given()
                .body(map.toString())
            .when()
                .post("/users")
                .then()
                .statusCode(401);

    }
    @Test(priority = 4)
    /**
     * Test Case Resource Not Found
     */
    public void testRNotFound(){
        baseURI = "https://gorest.co.in/public/v2";

        String body = given()
                .when()
                .get("/users/test")
                .then()
                .statusCode(404)

                .extract().body().asString();

        System.out.println(body);
    }
    @Test(priority = 1)
    /**
     * Get List (all users)
     */
    public void testGetList(){
        baseURI = "https://gorest.co.in/public/v2";

        String body = given()
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .extract().body().asString();
        System.out.println(body);
    }
}
