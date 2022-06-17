package arthursoares.dev.compareversion;

public class Program
{
	public static void main(String[] args)
	{
		var versionComparer = new VersionComparer();
		var result = versionComparer.compareVersions("1.2", "1.2.0.1");
		
		System.out.println(result);
	}
}
