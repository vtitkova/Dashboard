<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format"
	exclude-result-prefixes="fo">
	<xsl:output method="xml" version="1.0" omit-xml-declaration="no" indent="yes" />
	<xsl:param name="versionParam" select="'1.0'" />

	
	<xsl:template match="clientVisitPlanHeader">
		<fo:block margin-top="5px" margin-left="10px" font-size="11pt"
			color="#949599">
			<fo:inline>ESTATE AND VISIT INFORMATION</fo:inline>
		</fo:block>

		<fo:table margin-top="10px" table-layout="fixed" width="100%"
			border="1pt solid #E7E7E8" background-color="#e6f4fd">
			<fo:table-column column-width="1.5cm" />
			<fo:table-column column-width="5.0cm" />
			<fo:table-column column-width="1.0cm" />
			<fo:table-column column-width="1.2cm" />
			<fo:table-column column-width="2.0cm" /> <!-- "18.06.2011" -->
			<fo:table-column column-width="0.5cm" /> <!--  -->
			<fo:table-column column-width="1.2cm" /> <!-- "13:00" -->
			<fo:table-column column-width="0.3cm" /> <!-- "-" -->
			<fo:table-column column-width="1.2cm" /> <!-- "14:00" -->
			<fo:table-column column-width="proportional-column-width(1)" />
			<fo:table-body>
				<fo:table-row>
					<fo:table-cell display-align="center" padding=" 3 5 3 5 ">
						<fo:block padding="2pt" margin-bottom="2pt">
							Eiendom
						</fo:block>
					</fo:table-cell>
					<fo:table-cell display-align="center" padding=" 3 5 3 5 " number-columns-spanned="9">
						<fo:block padding="2pt" margin-bottom="2pt" background-color="#FFFFFF">
							<xsl:value-of select="estate" />
						</fo:block>
					</fo:table-cell>
				</fo:table-row>
				<fo:table-row>
					<fo:table-cell display-align="center" padding=" 3 5 3 5 ">
						<fo:block padding="2pt" margin-bottom="2pt">
							Megler
						</fo:block>
					</fo:table-cell>
					<fo:table-cell display-align="center" padding=" 3 5 3 5 ">
						<fo:block padding="2pt" margin-bottom="2pt" background-color="#FFFFFF">
							<xsl:value-of select="broker" />
						</fo:block>
					</fo:table-cell>
					<fo:table-cell display-align="center" padding=" 3 5 3 5 ">
						<fo:block padding="2pt" margin-bottom="2pt" >
							<fo:inline> </fo:inline>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell display-align="center" padding=" 3 5 3 5 ">
						<fo:block padding="2pt" margin-bottom="2pt">
							Visning
						</fo:block>
					</fo:table-cell>
					<fo:table-cell display-align="center" padding=" 3 5 3 5 ">
						<fo:block padding="2pt" margin-bottom="2pt"  background-color="#FFFFFF">
							<xsl:value-of select="viewingDate" />
						</fo:block>
					</fo:table-cell>
					<fo:table-cell display-align="center" padding=" 3 5 3 5 ">
						<fo:block padding="2pt" margin-bottom="2pt" >
							<fo:inline> </fo:inline>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell display-align="center" padding=" 3 5 3 5 ">
						<fo:block padding="2pt" margin-bottom="2pt"  background-color="#FFFFFF">
							<xsl:value-of select="viewingStart" />
						</fo:block>
					</fo:table-cell>
					<fo:table-cell display-align="center" padding=" 3 5 3 5 ">
						<fo:block padding="2pt" margin-bottom="2pt" >
							<fo:inline>-</fo:inline>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell display-align="center" padding=" 3 5 3 5 ">
						<fo:block padding="2pt" margin-bottom="2pt"  background-color="#FFFFFF">
							<xsl:value-of select="viewingEnd" />
						</fo:block>
					</fo:table-cell>
					<fo:table-cell display-align="center" padding=" 3 5 3 5 ">
						<fo:block padding="2pt" margin-bottom="2pt" >
							<fo:inline> </fo:inline>
						</fo:block>
					</fo:table-cell>
					
				</fo:table-row>
			</fo:table-body>
		</fo:table>
	</xsl:template>

	

</xsl:stylesheet>