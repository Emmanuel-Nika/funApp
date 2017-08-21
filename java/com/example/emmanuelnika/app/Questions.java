package com.example.emmanuelnika.app;

/**
 * Created by
 * Okot Emmanuel
 * Masiga David Kelvin
 * Nabwire Barbra Sandra
 * Lema James on 7/27/2017.
 */

public class Questions {

    public String question, choice, answer;

    String mQuestions[]={
            "Which is the first planet in the solar system",
            "Which is the second planet in the solar system",
            "Which is the third planet in the solar system",
            "Which is the fourth planet in the solar system",
            "Which is the fifth planet in the solar system",
            "Which is the sixth planet in the solar system",
            "Which is the seventh planet in the solar system",
            "Which is the eigth planet in the solar system",
            "Which is the ninth planet in the solar system",
            "How many days are in a week?",
            "What name is given to a young dog?",
            "What is the top colour in a rainbow?",
            "How many colours are in a rainbow?",
            "How many years are there in a millennium?",
            "What is the distance around a circle called?",
            "How many sides does a triangle have?",
            "Bees create what sweet substance?",
            "How many days are there in a fortnight?",
            "What % of an egg’s weight is the shell?",
            "How many days are there in June?",
            "Which planet in our Solar System is known for having a ring?",
            "In Jungle Book what kind of animal is Baloo?",
            "From what tree do acorns come?",
            "What comes after 4?",
            "What comes before 8?",
            "What farm animal says 'Moo?'",
            "What item tells the time?",
            "what animal mews?",
            "How many months are in a year?",
            "what name is given to a female dog?",
            "what name is given to a young duck?"
    };

    private String mChoices[][]={
            {"Mercury","Venus","Mars","Saturn"},
            {"Jupiter","Venus","Earth","Neptune"},
            {"Earth","Jupiter","Pluto","Venus"},
            {"Jupiter","Saturn","Mars","Earth"},
            {"Jupiter","Pluto","Mercury","Earth"},
            {"Uranus","Venus","Mars","Saturn"},
            {"Saturn","Pluto","Uranus","Earth"},
            {"Venus","Neptune","Pluto","Mars"},
            {"Mercury","Venus","Mars","Pluto"},
            {"5","7","8","10"},
            {"Kid","Cub","Calf","Puppy"},
            {"Blue","Green","Red","Black"},
            {"7","6","10","9"},
            {"100","1000","10","10000"},
            {"Circumference","Perimeter","Radius","Area"},
            {"4","2","3","5"},
            {"Sweet","Juice","Blueband","Honey"},
            {"14","30","7","12"},
            {"14%","30%","7%","12%"},
            {"30","28","29","31"},
            {"Mars","Saturn","Mercury","Pluto"},
            {"Lion","Cow","Goat","Bear"},
            {"Oak","mango","Eucalptus","Jackfruit"},
            {"3","5","6","7"},
            {"3","5","6","7"},
            {"Lion","Cow","Goat","Bear"},
            {"Clock","God","Man","Computer"},
            {"Goat","Cat","Sheep","Rabbit"},
            {"30","7","10","12"},
            {"Bitch","Doggy","Kid","Dog"},
            {"Duck","Duckless","Duckling","Duckee"},

    };

    private String mCorrectAnswers[]={"Mercury","Venus","Earth","Mars","Jupiter","Saturn","Uranus","Neptune","Pluto","7","Puppy","Red","7","1000","Circumference","3","Honey","14","12%","30",
            "Saturn","Bear","Oak","5","7","Cow","Clock","Cat","12","Bitch","Duckling"};

    String getQuestion(int a) {
        question = mQuestions[a];
        return question;
    }

    String getChoice1(int a) {
        choice = mChoices[a][0];
        return choice;
    }

    String getChoice2(int a) {
        choice = mChoices[a][1];
        return choice;
    }

    String getChoice3(int a) {
        choice = mChoices[a][2];
        return choice;
    }

    String getChoice4(int a) {
        choice = mChoices[a][3];
        return choice;
    }

    String getCorrectAnswer(int a){
        answer = mCorrectAnswers[a];
        return answer;
    }
}