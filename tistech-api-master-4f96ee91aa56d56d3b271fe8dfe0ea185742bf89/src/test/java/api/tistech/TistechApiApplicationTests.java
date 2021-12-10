package api.tistech;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TistechApiApplicationTests {

	@Test
	void contextLoads() {

		Exercise8 exercise8 = new  Exercise8 ();
                Exercise9 exercise9 = new  Exercise9 ();
                
                validateNullNumber(exercise8.getA());
                validateNullNumber(exercise8.getB());
                validadeLength (exercise9.getWord());
                validateNotEmptyBiArray(exercise9.getBiArray());
                
	}
  
        public void validadeLength (String word)
        {
            Assert.hasLength(word, "Must not be null or empty");
        }

        public void validateNotEmptyBiArray(String [][] array){
               Assert.notEmpty(array,"Array must not be empty");
        }

        public void validateNullNumber(int number){
            Assert.isNull(number,"Number must not be null");
        }

}
