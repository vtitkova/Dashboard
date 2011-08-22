<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format"
	exclude-result-prefixes="fo">
	<xsl:output method="xml" version="1.0" omit-xml-declaration="no" indent="yes" />
	<xsl:param name="versionParam" select="'1.0'" />
	
	<!--  .................. ............................................................................>
	<...  FINANCING PART begin ............................................................................>
	<...  .................. ..........................................................................-->
		
	<xsl:template match="financingPlan">
		<fo:block margin-top="15px" margin-left="10px" font-size="11pt" color="#949599">
			<fo:inline>FINANSIERINGSPLAN</fo:inline>
		</fo:block>
		<fo:table margin-top="10px" table-layout="fixed" width="100%" border="1pt solid #E7E7E8" background-color="#e6f4fd">
			<fo:table-column column-width="100%" />
			<fo:table-body>
				<fo:table-row>
					<fo:table-cell display-align="center" padding=" 3 5 3 5 ">
							<xsl:apply-templates select="lanLines" />
							<xsl:apply-templates select="equityLines" />
					</fo:table-cell>
				</fo:table-row>
			</fo:table-body>
		</fo:table>
		
		<fo:table margin-top="10px" table-layout="fixed" width="100%" border="1pt solid #E7E7E8" background-color="#e6f4fd">
			<fo:table-column column-width="100%" />
			<fo:table-body>
				<fo:table-row>
					<fo:table-cell display-align="center" padding=" 3 5 3 5 ">
								<xsl:call-template name="financingPlanAgreeTable"/>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-body>
		</fo:table>
		
		<fo:block margin-top="10px" margin-left="10px">
			<xsl:value-of select="financeSubText" />
		</fo:block>
	</xsl:template>

	<!--  .................. ............................................................................>
	<...  FINANCING PART end   ............................................................................>
	<...  .................. ..........................................................................-->




	<xsl:template match="lanLines">
		<fo:table table-layout="fixed" width="100%">
			<fo:table-column column-width="2.2cm" />
			<fo:table-column column-width="3.2cm" />
			<fo:table-column column-width="0.6cm" />
			<fo:table-column column-width="3.2cm" />
			<fo:table-column column-width="0.6cm" />
			<fo:table-column column-width="3.2cm" />
			<fo:table-column column-width="0.6cm" />
			<fo:table-column column-width="proportional-column-width(1)" />
			<fo:table-body>
				<xsl:apply-templates select="FinancingLanLine" />
			</fo:table-body>
		</fo:table>
	</xsl:template>
	

	<xsl:template match="FinancingLanLine">
		<fo:table-row>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					Lån
					</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" background-color="#FFFFFF">
					<xsl:value-of select="bankName" />
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					v/
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt"	background-color="#FFFFFF">
					<xsl:value-of select="contactName" />
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					Tlf.
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt"	background-color="#FFFFFF">
					<xsl:value-of select="phone" />
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					Kr.
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt"	background-color="#FFFFFF">
					<xsl:value-of select="amount" />
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>
			
			
		</fo:table-row>
	</xsl:template>
	

	<xsl:template match="equityLines">
		<fo:table table-layout="fixed" width="100%">
			<fo:table-column column-width="2.2cm" />
			<fo:table-column column-width="3.2cm" />
			<fo:table-column column-width="0.6cm" />
			<fo:table-column column-width="3.2cm" />
			<fo:table-column column-width="0.6cm" />
			<fo:table-column column-width="3.2cm" />
			<fo:table-column column-width="0.6cm" />
			<fo:table-column column-width="proportional-column-width(1)" />
			<fo:table-body>
				<xsl:apply-templates select="FinancingEquityLine" />
			</fo:table-body>
		</fo:table>
	</xsl:template>

	<xsl:template match="FinancingEquityLine">
		<fo:table-row>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					Egenkapital
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" background-color="#FFFFFF">
					<xsl:value-of select="bankName" />
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					v/
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt"	background-color="#FFFFFF">
					<xsl:value-of select="contactName" />
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					Tlf.
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt"	background-color="#FFFFFF">
					<xsl:value-of select="phone" />
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					Kr.
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt"	background-color="#FFFFFF">
					<xsl:value-of select="amount" />
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>
			
			
		</fo:table-row>
	</xsl:template>
	



















	<xsl:template name="financingPlanAgreeTable">
		<fo:table table-layout="fixed" width="100%">
			<fo:table-column column-width="7.0cm" />
			<fo:table-column column-width="0.8cm" />
			<fo:table-column column-width="0.8cm" />
			<fo:table-column column-width="0.8cm" />
			<fo:table-column column-width="0.8cm" />
			<fo:table-column column-width="6.0cm" />
			<fo:table-column column-width="proportional-column-width(1)" />
			<fo:table-body>
				<xsl:call-template name="financingPlanAgreeTableRow" />
			</fo:table-body>
		</fo:table>
	</xsl:template>
	
	<xsl:template name="financingPlanAgreeTableRow">
		<fo:table-row>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					Jeg/Vi ønsker finansieringstilbud fra Sparebank 1
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" background-color="#FFFFFF">
					<xsl:if test="financeOffer = 'true'">
					<fo:inline>X</fo:inline>
					</xsl:if>
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					Ja
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt"	background-color="#FFFFFF">
					<xsl:if test="financeOffer = 'false'">
					<fo:inline>X</fo:inline>
					</xsl:if>
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					Nei
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
				</fo:block>
			</fo:table-cell>
		</fo:table-row>
	</xsl:template>
	
	


</xsl:stylesheet>