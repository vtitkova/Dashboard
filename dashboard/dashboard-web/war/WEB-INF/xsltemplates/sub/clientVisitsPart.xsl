<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format"
	exclude-result-prefixes="fo">
	<xsl:output method="xml" version="1.0" omit-xml-declaration="no" indent="yes" />
	<xsl:param name="versionParam" select="'1.0'" />

	
	<xsl:template match="clientVisits">
		
		<fo:table margin-top="10px" table-layout="fixed" width="100%" border="1pt solid #E7E7E8">
			<fo:table-column column-width="0.6cm" /> <!-- "NR" -->
			<fo:table-column column-width="5.0cm" /> <!-- "Client" -->
			<fo:table-column column-width="proportional-column-width(1)" /> <!-- "Comments" -->
			<fo:table-column column-width="1.2cm" /> <!-- "Status" -->
			<fo:table-column column-width="2.0cm" /> <!-- "Created" -->
			<fo:table-body>
				<fo:table-row background-color="#C6CCD2">
					<fo:table-cell display-align="center" padding=" 3 5 3 5 " border-right="1pt solid #C6CCD2">
						<fo:block padding="2pt" margin-bottom="2pt">
							NR
						</fo:block>
					</fo:table-cell>
					<fo:table-cell display-align="center" padding=" 3 5 3 5 " border-right="1pt solid #C6CCD2">  
						<fo:block padding="2pt" margin-bottom="2pt">
							Client
						</fo:block>
					</fo:table-cell>
					<fo:table-cell display-align="center" padding=" 3 5 3 5 " border-right="1pt solid #C6CCD2">
						<fo:block padding="2pt" margin-bottom="2pt">
							Comments
						</fo:block>
					</fo:table-cell>
					<fo:table-cell display-align="center" padding=" 3 5 3 5 " border-right="1pt solid #C6CCD2">
						<fo:block padding="2pt" margin-bottom="2pt">
							Status
						</fo:block>
					</fo:table-cell>
					<fo:table-cell display-align="center" padding=" 3 5 3 5 ">
						<fo:block padding="2pt" margin-bottom="2pt">
							Created
						</fo:block>
					</fo:table-cell>
				</fo:table-row>
				<xsl:apply-templates select="clientVisit" />
			</fo:table-body>
		</fo:table>
	</xsl:template>

	<xsl:template match="clientVisit">
		<fo:table-row background-color="#FFFFFF" border-top="1pt solid #E7E7E8">
			<fo:table-cell display-align="center" padding=" 3 5 3 5 " border-right="1pt solid #C6CCD2">
				<fo:block padding="2pt" margin-bottom="2pt">
					<xsl:value-of select="nr" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell display-align="center" padding=" 3 5 3 5 " border-right="1pt solid #C6CCD2">
				<fo:block padding="2pt" margin-bottom="2pt">
					<xsl:value-of select="client" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell display-align="center" padding=" 3 5 3 5 " border-right="1pt solid #C6CCD2">
				<fo:block padding="2pt" margin-bottom="2pt">
					<xsl:value-of select="comments" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell display-align="center" padding=" 3 5 3 5 " border-right="1pt solid #C6CCD2">
				<fo:block padding="2pt" margin-bottom="2pt">
					<xsl:value-of select="status" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell display-align="center" padding=" 3 5 3 5 ">
				<fo:block padding="2pt" margin-bottom="2pt">
					<xsl:value-of select="created" />
				</fo:block>
			</fo:table-cell>
		</fo:table-row>
	</xsl:template>
	
	

</xsl:stylesheet>