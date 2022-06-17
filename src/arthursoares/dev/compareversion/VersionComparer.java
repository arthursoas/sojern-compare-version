package arthursoares.dev.compareversion;

public class VersionComparer
{
	public int compareVersions(String version1, String version2)
	{
		var splittedVersion1 = version1.split("\\.");
		var splittedVersion2 = version2.split("\\.");
		
		var maxRevisionLevels = getMaxRevisionLevels(
				splittedVersion1,
				splittedVersion2);
		var revisionLevelLengths = getRevisionLevelsLengths(
				splittedVersion1,
				splittedVersion2,
				maxRevisionLevels);
		
		var version1AsInteger = convertVersionStringToInt(splittedVersion1, revisionLevelLengths);
		var version2AsInteger = convertVersionStringToInt(splittedVersion2, revisionLevelLengths);
		
		if (version1AsInteger == version2AsInteger)
		{
			return 0;
		}
		
		return version1AsInteger > version2AsInteger ? 1 : -1;
	}
	
	private int getMaxRevisionLevels(String[] splittedVersion1, String[] splittedVersion2)
	{
		return splittedVersion1.length > splittedVersion2.length ?
			splittedVersion1.length :
			splittedVersion2.length;
	}
	
	private int[] getRevisionLevelsLengths(String[] splittedVersion1, String[] splittedVersion2, int maxRevisionLevels)
	{
		var lengths = new int[maxRevisionLevels];
		
		
		for (var index = 0; index < splittedVersion1.length; index++)
		{
			lengths[index] = splittedVersion1[index].length();
		}
		for (var index = 0; index < splittedVersion2.length; index++)
		{
			if (lengths[index] < splittedVersion2[index].length())
			{
				lengths[index] = splittedVersion2[index].length();				
			}
		}
		
		return lengths;
	}
	
	private long convertVersionStringToInt(String[] splittedVersion, int[] revisionLevelLengths)
	{
		var versionNumber = "";
		
		for (var index = 0; index < revisionLevelLengths.length; index++)
		{
			if (index < splittedVersion.length)
			{
				var revisionLevel = splittedVersion[index];
				var levelLength = revisionLevel.length();
				versionNumber += generateZerosString(revisionLevelLengths[index] - levelLength);
				versionNumber += revisionLevel;
				
				continue;
			}
			
			versionNumber += generateZerosString(revisionLevelLengths[index]);
		}
		
		return Long.parseLong(versionNumber);
	}
	
	private String generateZerosString(int amount)
	{
		var zeros = "";
		for (var index = 0; index < amount; index++)
		{
			zeros += "0";
		}
		
		return zeros;
	}
}
