<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format"
	exclude-result-prefixes="fo">
	<xsl:output method="xml" version="1.0" omit-xml-declaration="no"
		indent="yes" />
	<xsl:param name="versionParam" select="'1.0'" />

	<!--
		..................
		............................................................................>
		<... TERMS PART begin
		............................................................................>
		<... ..................
		..........................................................................
	-->
	<xsl:template match="terms">
		<fo:block break-before="page">
  		</fo:block> 
		<fo:block margin-top="0px" font-size="11pt" color="#949599">
			<fo:inline><xsl:apply-templates select="headerHTML" /></fo:inline>
			<fo:inline><xsl:apply-templates select="bodyHTML"   /></fo:inline>
		</fo:block>
	</xsl:template>


	<xsl:template match="headerHTML">
		<fo:block margin-top="0px" font-size="11pt" color="#949599">
			<fo:inline>
				<xsl:apply-templates select="*|text()"/>
			</fo:inline>
		</fo:block>
	</xsl:template>
	
	<xsl:template match="bodyHTML">
		<fo:block margin-top="10px" font-size="11pt" color="#949599">
			<fo:inline>
				<xsl:apply-templates select="*|text()"/>
			</fo:inline>
		</fo:block>
	</xsl:template>
	

	<xsl:template match="p">
 		 <fo:block margin-top="3px" margin-left="5px" font-size="8pt" color="#949599">
  		 	<xsl:apply-templates select="*|text()"/>
  		 </fo:block>
	</xsl:template>
	
	<xsl:template match="p1">
 		 <fo:block margin-top="8px" margin-left="5px" font-size="8pt" color="#949599">
  		 	<xsl:apply-templates select="*|text()"/>
  		 </fo:block>
	</xsl:template>

	<xsl:template match="h1">
 		 <fo:block margin-top="0px" margin-left="5px" font-size="20pt" color="#02BEE4">
  		 	<xsl:apply-templates select="*|text()"/>
  		 </fo:block>
	</xsl:template>
	<xsl:template match="h2">
 		 <fo:block margin-top="5px" margin-left="5px" font-size="10pt" color="#202020">
  		 	<xsl:apply-templates select="*|text()"/>
  		 </fo:block>
	</xsl:template>



</xsl:stylesheet>