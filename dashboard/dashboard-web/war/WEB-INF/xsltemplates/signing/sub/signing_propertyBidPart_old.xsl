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
		<... PROPERTY & BID PART begin
		............................................................................>
		<... ..................
		..........................................................................
	-->

	<xsl:template match="propertyBid">
		<fo:block margin-top="5px" margin-left="10px" font-size="11pt"
			color="#949599">
			<fo:inline>BINDENDE BUD PÅ EIENDOMMEN</fo:inline>
		</fo:block>

		<fo:table margin-top="10px" table-layout="fixed" width="100%"
			border="1pt solid #E7E7E8" background-color="#e6f4fd">
			<fo:table-column column-width="100%" />
			<fo:table-body>
				<fo:table-row>
					<fo:table-cell display-align="center" padding=" 3 5 3 5 ">
						<xsl:apply-templates select="property" />
						<xsl:apply-templates select="bid" />
					</fo:table-cell>
				</fo:table-row>
			</fo:table-body>
		</fo:table>
	</xsl:template>

	<!--
		..................
		............................................................................>
		<... FINANCING PART end
		............................................................................>
		<... ..................
		..........................................................................
	-->

	<xsl:template match="property">
		<fo:table table-layout="fixed" width="100%">
			<fo:table-column column-width="2.2cm" />
			<fo:table-column column-width="2.9cm" />
			<fo:table-column column-width="1.5cm" />
			<fo:table-column column-width="2.9cm" />
			<fo:table-column column-width="1.5cm" />
			<fo:table-column column-width="1.8cm" />
			<fo:table-column column-width="proportional-column-width(1)" />
			<fo:table-body>
				<xsl:call-template name="propertyTableRows" />
			</fo:table-body>
		</fo:table>
	</xsl:template>


	<xsl:template name="propertyTableRows">
		<!-- First ROw -->
		<fo:table-row>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt" >
					Eiendom
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="4">
				<fo:block padding="2pt" margin-bottom="2pt"
					background-color="#FFFFFF">
					<xsl:value-of select="name" />
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					Oppdragsnr.
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt"
					background-color="#FFFFFF">
					<xsl:value-of select="orderNumber" />
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>
		</fo:table-row>

		<!-- 2 Row -->
		<fo:table-row>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					Postnr.
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt"
					background-color="#FFFFFF">
					<xsl:value-of select="postCode" />
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					Poststed
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="2">
				<fo:block padding="2pt" margin-bottom="2pt"
					background-color="#FFFFFF">
					<xsl:value-of select="postCity" />
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>
		</fo:table-row>

		<!-- 3 Row -->
		<fo:table-row>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					G.nr.
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" background-color="#FFFFFF">
					<xsl:value-of select="gnr" />
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					B.nr.
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt"
					background-color="#FFFFFF">
					<xsl:value-of select="bnr" />
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					S.nr.
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>
		</fo:table-row>

	</xsl:template>





	<xsl:template match="bid">
		<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
		</fo:block>
		<fo:table table-layout="fixed" width="100%">
			<fo:table-column column-width="2.2cm" />
			<fo:table-column column-width="13.3cm" />
			<fo:table-column column-width="proportional-column-width(1)" />
			<fo:table-body>
				<xsl:call-template name="bidTableRowsA"></xsl:call-template>
			</fo:table-body>
		</fo:table>
		
		<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt" font-size="7pt">
		(I tillegg kommer omkostninger i h.h.t. salgsoppgave)
		</fo:block>
		
		<fo:table table-layout="fixed" width="100%">
			<fo:table-column column-width="03.5cm" />
			<fo:table-column column-width="02.0cm" />
			<fo:table-column column-width="04.0cm" />
			<fo:table-column column-width="02.0cm" />
			<fo:table-column column-width="02.0cm" />
			<fo:table-column column-width="01.8cm" />
			<fo:table-column column-width="proportional-column-width(1)" />
			<fo:table-body>
				<xsl:call-template name="bidTableRowsB"></xsl:call-template>
			</fo:table-body>
		</fo:table>
		
		
		<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt" font-size="7pt">
		(Akseptfristen må være minimum 24 timer etter siste annonserte visning).
		</fo:block>
	</xsl:template>


	<xsl:template name="bidTableRowsA">
		<!-- First ROw -->
		<fo:table-row>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					Bud stort Kr.
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" background-color="#FFFFFF">
					<xsl:value-of select="amount" />
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>
		</fo:table-row>
		
		
		<!-- 2 ROw -->
		<fo:table-row>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					skriver kroner
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" background-color="#FFFFFF">
					<xsl:value-of select="amountString" />
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					<fo:inline>00/100</fo:inline>
				</fo:block>
			</fo:table-cell>
	
		</fo:table-row>

	</xsl:template>









	<xsl:template name="bidTableRowsB">
		<!-- First ROw -->
		<fo:table-row>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					Eventuelle forbehold:
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="5">
				<fo:block padding="2pt" margin-bottom="2pt" background-color="#FFFFFF">
					<xsl:value-of select="info"/>
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>
		</fo:table-row>
		
		
		
		<!-- 2 ROw -->
		<fo:table-row>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					Ønsket overtagelsesdato
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" background-color="#FFFFFF">
					<xsl:value-of select="dateFrom" />
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					<fo:inline>Akseptfrist</fo:inline>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" background-color="#FFFFFF">
					<xsl:value-of select="dateTo" />
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>
	
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					<fo:inline>Klokkeslett</fo:inline>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" background-color="#FFFFFF">
					<xsl:value-of select="timeTo" />
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>
	
		</fo:table-row>

	</xsl:template>


</xsl:stylesheet>