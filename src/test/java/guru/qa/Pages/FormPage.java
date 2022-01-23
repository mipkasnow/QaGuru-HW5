package guru.qa.Pages;

import com.codeborne.selenide.ElementsCollection;
import com.github.javafaker.Faker;

import java.util.Random;

import static com.codeborne.selenide.Selenide.*;


public class FormPage {

    Faker faker = new Faker();

    public String fillFirstName(){
        String firstName = faker.name().firstName();
        $("#firstName").setValue(firstName);
        return firstName;
    }

    public String fillLastName(){
        String lastName = faker.name().lastName();
        $("#lastName").setValue(lastName);
        return lastName;
    }

    public String fillEmail(){
        String email = faker.name().username() + "@mail.ru";
        $("#userEmail").setValue(email);
        return email;
    }

    public String chooseGender(String gender){
        String gnd = null;
        if(gender.equals("1")){
            $("[for='gender-radio-" + gender + "']").click();
            gnd = "Male";
        }
        else if(gender.equals("2")){
            $("[for='gender-radio-" + gender + "']").click();
            gnd = "Female";
        }

        return gnd;
    }

    public String fillPhoneNumber(){
        String phoneNumber = Long.toString(faker.number().numberBetween(1000000000, 2000000000));
        $("#userNumber").setValue(phoneNumber);
        return phoneNumber;
    }

    public String chooseAllHobbies(){
        ElementsCollection hobbies = $$("[for*='hobbies-checkbox']");
        int count = hobbies.size();
        for (int i = 0; i < count; i++) {
            hobbies.get(i).click();
        }
        String choosenHobbies = "Sports, Reading, Music";
        return choosenHobbies;
    }

    public String choseSubject(){
        String[] subjects  = new String[] {"Chemistry", "Computer Science", "Commerce",
                "Economics", "Maths", "Accounting", "Arts", "Social Studies", "English"};
        int i = faker.number().numberBetween(0, 8);
        String subject = subjects[i];
        $("#subjectsInput").setValue(subject).pressEnter();
        return subject;
    }

    public String uploadFile(){
        String fileName = "qa-guru.txt";
        $("input[id='uploadPicture']").uploadFromClasspath(fileName);
        return fileName;
    }

    public String fillAddress(){
        String address = faker.address().fullAddress();
        $("[placeholder='Current Address']").setValue(address);
        return address;
    }

    public void submit(){
        $("#submit").scrollIntoView(true).click();
    }

    public String selectStateAndCity(){
        String[] states  = new String[] {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        String[] NCR_cities = new String[] {"Delhi", "Gurgaon", "Noida"};
        String[] Uttar_cities = new String[] {"Agra", "Lucknow", "Merrut"};
        String[] Haryana_cities = new String[] {"Karnal", "Panipat"};
        String[] Rajasthan_cities = new String[] {"Jaipur", "Jaiselmer"};
        String state = null;
        String city = null;
        int i = faker.number().numberBetween(0, 3);

        if(i==0){
            state = states[i];
            city = (NCR_cities[new Random().nextInt(NCR_cities.length)]);
        }
        else if(i==1){
            state = states[i];
            city = (Uttar_cities[new Random().nextInt(Uttar_cities.length)]);
        }
        else if(i==2){
            state = states[i];
            city = (Haryana_cities[new Random().nextInt(Haryana_cities.length)]);
        }
        else if(i==3){
            state = states[i];
            city = (Rajasthan_cities[new Random().nextInt(Rajasthan_cities.length)]);
        }

        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();

        String stateAndCity = state + " " + city;
        return stateAndCity;
    }

    public String chooseDateOfBirth(){
        open("https://demoqa.com/automation-practice-form");
        String[] months  = new String[] {"January", "February", "March", "April",
        "May", "June", "July", "August", "September", "October", "November", "December"};
        int m = faker.number().numberBetween(0, 11);
        String month = (months[new Random().nextInt(months.length)]);
        $("#dateOfBirthInput").click();
        $("[class*='month-select']").selectOptionContainingText(month);

        int y = faker.number().numberBetween(1900, 2021);
        String year = Long.toString(y);
        $("[class*='year-select']").selectOptionByValue(year);

        int d = faker.number().numberBetween(1, 28);
        String day = Long.toString(d);
        $x("//*[contains(@class, 'react-datepicker__day') and normalize-space(text()) = '" + day + "' " +
                "and not(contains(@class, 'react-datepicker__day--outside-month'))]").click();

        if(d<10){
            day = "0" + day;
        }

        String dateOfBirth = day + " " + month + "," + year;
        return dateOfBirth;
    }


}
