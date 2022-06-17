package arthursoares.dev.compareversion;

public class Program
{
	public static void main(String[] args)
	{
		var versionComparer = new VersionComparer();
		var result = versionComparer.compareVersions("1.3", "1.3.0");
		
		System.out.println(result);
	}
}
