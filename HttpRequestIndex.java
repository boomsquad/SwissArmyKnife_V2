public class HttpRequestIndex extends HttpRequest
{
    public Boolean parseIndex()
    {
        for (final String line: urlContent)
        {
            parseLine(line);
        }
        return true;
    }

    private void parseLine(final String line)
    {
        System.out.println(line);

        //Wherever there is an ending quotation mark, the line is broken
        final String[] subString = line.split("\"");

        
    }
}