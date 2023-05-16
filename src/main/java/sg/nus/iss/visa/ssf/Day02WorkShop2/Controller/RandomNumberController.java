package sg.nus.iss.visa.ssf.Day02WorkShop2.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import sg.nus.iss.visa.ssf.Day02WorkShop2.Model.image;
import sg.nus.iss.visa.ssf.Day02WorkShop2.Service.RandomNumberService;



@Controller
public class RandomNumberController {

    //injecting service class depedency
    @Autowired
    RandomNumberService service;


    @GetMapping("/home")
    public String langingPage(){
        return "Home";
    }

    @GetMapping("/get")
    public String generateRandomNumbers(Model model, HttpServletRequest request){
    
        //fetch input parameter
        int number = Integer.parseInt(request.getParameter("number"));

        System.out.println("input no is: " +number);

         // check condition if number is between 1-30
         if (number < 1 || number > 30) {
            String errorMessage = "Invalid Number: " + number;
            model.addAttribute("errorMessage", errorMessage);
            return "Home";
        }
        //calling service method to generate random numbers
        List<Integer> randomNumbers = service.generateRanNumbers(number);


        //populate image objects and create list of Image objects
        List<image> imageList = new ArrayList<image>();

       

        for(int randomNumber : randomNumbers){
            imageList.add(new image(Integer.toString(randomNumber), "/images/"+Integer.toString(randomNumber)+".png"));
        }
        System.out.println("image list :" + imageList);

        model.addAttribute(imageList);

        return "Display";
    }
    

}