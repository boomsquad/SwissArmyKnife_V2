import java.util.ArrayList;

public class JSONValidateIndex extends HttpRequest
{
    public Boolean parseIndex()
    {
        for (final String line: urlContent)
        {
            parseLine(line);
        }
        return true;
    }

    private String firstName;
    private String lastName;
    private String preferredName;
    private String email;

    //my getter functions
    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public String getPreferredName()
    {
        return preferredName;
    }
    public String getEmail()
    {
        return email;
    }

    //my setter functions
    public void setFirstName(String firstNameIn)
    {
        firstName = firstNameIn;
    }
    public void setLastName(String lastNameIn)
    {
        lastName = lastNameIn;
    }
    public void setPreferredName(String preferredNameIn)
    {
        preferredName = preferredNameIn;
    }
    public void setEmail(String emailIn)
    {
        email = emailIn;
    }

    public void parseValidate(ArrayList<String> lines)
    {
        for (final String line: lines)
        {
            String [] subString = line.split("\"");

            if (subString.length > 4)
            {
                if (subString[1].equals("firstName"))
                {
                    firstName = subString[3];
                    System.out.println(firstName);
                }
                else if (subString[1].equals("lastName"))
                {
                    lastName = subString[3];
                    System.out.println(lastName);
                }
                else if (subString[1].equals("email"))
                {
                    email = subString[3];
                    System.out.println(email);
                }
                else if (subString[1].equals("preferredName"))
                {
                    preferredName = subString[3];
                    System.out.println(preferredName);
                }
            }
        }
    }

    //provided with the link you gave us
    static boolean isValid(String email)
    {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    public void validating()
    {
        System.out.println("Validating...");
        if (firstName.length() < 2 || firstName.length() > 16)
        {
            System.out.println("Invalid first name!");
        }
        else if (firstName.length() == 0)
        {
            System.out.println("Invalid there is no first name!");
        }
        else 
        {
            System.out.println("Valid first name!");
        }

        if (lastName.length() < 2 || lastName.length() > 16)
        {
            System.out.println("Invalid last name!");
        }
        else if (lastName.length() == 0)
        {
            System.out.println("Invalid there is no last name!");
        }
        else 
        {
            System.out.println("Valid last name!");
        }

        if (preferredName.length() < 2 || preferredName.length() > 16)
        {
            System.out.println("Invalid preferred name!");
        }
        else 
        {
            System.out.println("Valid preferred name!");
        }

        if (email.length() != 0)
        {
            if (isValid(email))
            {
                System.out.println("Email is valid!\n");
            }
            else 
            {
                System.out.println("Email is invalid!\n");
            }
        }
    }

    private void parseLine(final String line)
    {
        //Wherever there is an ending quotation mark, the line is broken
        final String[] subString = line.split("\"");

        if (subString.length >= 11)
        {
            if (subString[11].indexOf("https://") > -1)
            {
                String index = subString[11];

                JSONValidateIndex requestIndex = new JSONValidateIndex();
                if ( requestIndex.readURL(index))
                {
                    System.out.println(requestIndex);
                    parseValidate(requestIndex.urlContent);
                    validating();
                }
            }
        }
    }
}