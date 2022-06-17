package arthursoares.dev.compareversion;

public class VersionComparer
{
	public int compareVersions(String version1, String version2)
	{
		var maxRevisionLevels = getMaxRevisionLevels(version1, version2);
		var revisionLevelLengths = getRevisionLevelsLengths(version1, version2, maxRevisionLevels);
		
		var version1AsInteger = convertVersionStringToInt(version1, revisionLevelLengths);
		var version2AsInteger = convertVersionStringToInt(version2, revisionLevelLengths);
		
		if (version1AsInteger == version2AsInteger)
		{
			return 0;
		}
		
		if (version1AsInteger > version2AsInteger)
		{
			return 1;
		}
		
		return -1;
	}
	
	private int getMaxRevisionLevels(String version1, String version2)
	{
		var version1Levels = version1.split("\\.");
		var version2Levels = version2.split("\\.");
		
		return version1Levels.length > version2Levels.length ?
			version1Levels.length :
			version2Levels.length;
	}
	
	private int[] getRevisionLevelsLengths(String version1, String version2, int maxRevisionLevels)
	{
		var lengths = new int[maxRevisionLevels];
		
		var version1Levels = version1.split("\\.");
		for (var index = 0; index < version1Levels.length; index++)
		{
			lengths[index] = version1Levels[index].length();
		}
		
		var version2Levels = version2.split("\\.");
		for (var index = 0; index < version2Levels.length; index++)
		{
			if (lengths[index] < version2Levels[index].length())
			{
				lengths[index] = version2Levels[index].length();				
			}
		}
		
		return lengths;
	}
	
	private int convertVersionStringToInt(String version, int[] revisionLevelLengths)
	{
		var versionLevels = version.split("\\.");
		var versionNumber = "";
		
		for (var index = 0; index < revisionLevelLengths.length; index++)
		{
			if (index < versionLevels.length)
			{
				var revisionLevel = versionLevels[index];
				var levelLength = revisionLevel.length();
				versionNumber += generateZerosString(revisionLevelLengths[index] - levelLength);
				versionNumber += revisionLevel;
			}
			else
			{
				versionNumber += generateZerosString(revisionLevelLengths[index]);
			}
		}
		
		return Integer.parseInt(versionNumber);
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
