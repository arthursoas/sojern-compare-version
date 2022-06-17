package arthursoares.dev.compareversion.tests;

import arthursoares.dev.compareversion.VersionComparer;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class VersionComparerTests
{
	private VersionComparer versionComparer;
	
	@Before
	public void initialize()
	{
		versionComparer = new VersionComparer();
	}
	
	@Test
	public void compareVersions_whenVersionsAreIdentical_ShouldReturnZero()
	{
		// Arrange
		var version = "1.0.0";
		
		// Act
		var result = versionComparer.compareVersions(version, version);
		
		// Assert
		assertThat(result, is(0));
	}
	
	@Test
	public void compareVersions_whenVersionsAreSimilar_ShouldReturnZero()
	{
		// Arrange
		var version1 = "1.0.1";
		var version2 = "1.0.1.0.0.0";
		
		// Act
		var result = versionComparer.compareVersions(version1, version2);
		
		// Assert
		assertThat(result, is(0));
	}
	
	@Test
	public void compareVersions_whenVersion1IsGreaterThanVersion2_ShouldReturnOne()
	{
		// Arrange
		var version1 = "1.0.2";
		var version2 = "1.0.1.0.0.0";
		
		// Act
		var result = versionComparer.compareVersions(version1, version2);
		
		// Assert
		assertThat(result, is(1));
	}
	
	@Test
	public void compareVersions_whenVersion1IsSmallerThanVersion2_ShouldReturnMinusOne()
	{
		// Arrange
		var version1 = "1.0.0";
		var version2 = "1.0.1.0.0.0";
		
		// Act
		var result = versionComparer.compareVersions(version1, version2);
		
		// Assert
		assertThat(result, is(-1));
	}
	
	@Test
	public void compareVersions_whenVersion2HasMoreLevelsThanVersion1_ShouldReturnSameResult()
	{
		// Arrange
		var version1 = "1.0.0.0.0.0.0.0.0.0.0";
		var version2 = "1.0.1.0.0.0";
		
		// Act
		var result = versionComparer.compareVersions(version1, version2);
		
		// Assert
		assertThat(result, is(-1));
	}
}
