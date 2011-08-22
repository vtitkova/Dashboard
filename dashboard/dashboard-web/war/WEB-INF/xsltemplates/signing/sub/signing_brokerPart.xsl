<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format"
	exclude-result-prefixes="fo">
	<xsl:output method="xml" version="1.0" omit-xml-declaration="no" indent="yes" />
	<xsl:param name="versionParam" select="'1.0'" />
	
	<!--  .................. ............................................................................>
	<...  broker PART begin ............................................................................>
	<...  .................. ..........................................................................-->
	<xsl:template match="brokerPart">
		<fo:block margin-top="20px" margin-left="10px" font-size="11pt"
			color="#949599">
			<fo:inline>(TIL BRUK FOR MEGLER). PÅ UENDREDE VILKÅR FORHØYES BUDET TIL:
			</fo:inline>
		</fo:block>
		<fo:table margin-top="10px" table-layout="fixed" width="100%" border="1pt solid #E7E7E8" background-color="#e6f4fd">
			<fo:table-column column-width="100%" />
			<fo:table-body>
				<fo:table-row>
					<fo:table-cell display-align="center" padding=" 3 5 3 5 ">
						<fo:table table-layout="fixed" width="100%">
							<fo:table-column column-width="2.2cm" />
							<fo:table-column column-width="3.0cm" />
							<fo:table-column column-width="0.9cm" />
							<fo:table-column column-width="3.5cm" />
							<fo:table-column column-width="1.3cm" />
							<fo:table-column column-width="proportional-column-width(1)" />
							<fo:table-body>
								<xsl:call-template name="brokerPlanFinRow" />
								<xsl:call-template name="brokerPlanFinRow" />
								<xsl:call-template name="brokerPlanFinRow" />
							</fo:table-body>
						</fo:table>
						<fo:table table-layout="fixed" width="100%">
							<fo:table-column column-width="2.2cm" />
							<fo:table-column column-width="6.2cm" />
							<fo:table-column column-width="1.2cm" />
							<fo:table-column column-width="1.3cm" />
							<fo:table-column column-width="1.3cm" />
							<fo:table-column column-width="2.4cm" />
							<fo:table-column column-width="proportional-column-width(1)" />
							<fo:table-body>
								<xsl:call-template name="brokerPlanFinRowA" />
							</fo:table-body>
						</fo:table>
						<fo:table table-layout="fixed" width="100%">
							<fo:table-column column-width="2.2cm" />
							<fo:table-column column-width="3.0cm" />
							<fo:table-column column-width="1.8cm" />
							<fo:table-column column-width="2.6cm" />
							<fo:table-column column-width="1.3cm" />
							<fo:table-column column-width="1.3cm" />
							<fo:table-column column-width="2.4cm" />
							<fo:table-column column-width="proportional-column-width(1)" />
							<fo:table-body>
								<xsl:call-template name="brokerPlanFinRowB" />
							</fo:table-body>
						</fo:table>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-body>
		</fo:table>
		<fo:table margin-top="10px" table-layout="fixed" width="100%" border="1pt solid #E7E7E8" background-color="#e6f4fd">
			<fo:table-column column-width="100%" />
			<fo:table-body>
				<fo:table-row>
					<fo:table-cell display-align="center" padding=" 3 5 3 5 ">
						<xsl:apply-templates select="broker" />
						<xsl:apply-templates select="office" />
					</fo:table-cell>
				</fo:table-row>
			</fo:table-body>
		</fo:table>
	</xsl:template>

	<xsl:template name="brokerPlanFinRow">
		<fo:table-row >
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">Kroner</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" background-color="#FFFFFF" >
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					Frist
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" background-color="#FFFFFF" >
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					Megler
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" background-color="#FFFFFF">
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>
		</fo:table-row>
	</xsl:template>
	<xsl:template name="brokerPlanFinRowA">
		<fo:table-row >
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					Forbehold om
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" background-color="#FFFFFF">
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					strøket.
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					Dato/Kl.
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" background-color="#FFFFFF">
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					Meglers signatur
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" background-color="#FFFFFF">
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>
		</fo:table-row>
	</xsl:template>
	<xsl:template name="brokerPlanFinRowB">
		<fo:table-row >
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					Finansiering kr.
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" background-color="#FFFFFF">
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>			
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					bekreftet av
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" background-color="#FFFFFF">
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					Dato/Kl.
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" background-color="#FFFFFF">
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					Meglers signatur
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" background-color="#FFFFFF">
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>
		</fo:table-row>
	</xsl:template>
	
	
	
	<xsl:template match="broker">
		<fo:table table-layout="fixed" width="100%">
			<fo:table-column column-width="2.2cm" />
			<fo:table-column column-width="6.0cm" />
			<fo:table-column column-width="1.3cm" />
			<fo:table-column column-width="3.9cm" />
			<fo:table-column column-width="1.5cm" />
			<fo:table-column column-width="proportional-column-width(1)" />
			<fo:table-body>
				<fo:table-row>
					<fo:table-cell>
						<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
						Megler
						</fo:block>
					</fo:table-cell>
					<fo:table-cell>
						<fo:block padding="2pt" margin-bottom="2pt" background-color="#FFFFFF">
							<xsl:value-of select="name"/><fo:inline> </fo:inline>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell>
						<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
						E-post
						</fo:block>
					</fo:table-cell>
					<fo:table-cell>
						<fo:block padding="2pt" margin-bottom="2pt" background-color="#FFFFFF">
						<xsl:value-of select="email"/><fo:inline> </fo:inline>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell>
						<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
						Telefon
						</fo:block>
					</fo:table-cell>
					<fo:table-cell>
						<fo:block padding="2pt" margin-bottom="2pt" background-color="#FFFFFF">
						<xsl:value-of select="phone"/><fo:inline> </fo:inline>
						</fo:block>
					</fo:table-cell>
					
				</fo:table-row>
			</fo:table-body>
		</fo:table>	
	</xsl:template>
	
	
	<xsl:template match="office">
	<fo:table table-layout="fixed" width="100%">
			<fo:table-column column-width="2.2cm" />
			<fo:table-column column-width="6.0cm" />
			<fo:table-column column-width="1.3cm" />
			<fo:table-column column-width="3.9cm" />
			<fo:table-column column-width="1.5cm" />
			<fo:table-column column-width="proportional-column-width(1)" />
			<fo:table-body>
				<fo:table-row>
					<fo:table-cell>
						<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
						Meglerkontor
						</fo:block>
					</fo:table-cell>
					<fo:table-cell>
						<fo:block padding="2pt" margin-bottom="2pt" background-color="#FFFFFF">
							<xsl:value-of select="name"/><fo:inline> </fo:inline>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell>
						<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
						E-post
						</fo:block>
					</fo:table-cell>
					<fo:table-cell>
						<fo:block padding="2pt" margin-bottom="2pt" background-color="#FFFFFF">
						<xsl:value-of select="email"/><fo:inline> </fo:inline>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell>
						<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
						Telefon
						</fo:block>
					</fo:table-cell>
					<fo:table-cell>
						<fo:block padding="2pt" margin-bottom="2pt" background-color="#FFFFFF">
						<xsl:value-of select="phone"/><fo:inline> </fo:inline>
						</fo:block>
					</fo:table-cell>
				</fo:table-row>
				<fo:table-row>
					<fo:table-cell>
						<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
						Adresse
						</fo:block>
					</fo:table-cell>
					<fo:table-cell number-columns-spanned="3">
						<fo:block padding="2pt" margin-bottom="2pt" background-color="#FFFFFF">
							<xsl:value-of select="address"/><fo:inline> </fo:inline>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell>
						<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
						Telefaks
						</fo:block>
					</fo:table-cell>
					<fo:table-cell>
						<fo:block padding="2pt" margin-bottom="2pt" background-color="#FFFFFF">
							<xsl:value-of select="fax"/><fo:inline> </fo:inline>
						</fo:block>
					</fo:table-cell>
				
				</fo:table-row>

			</fo:table-body>
		</fo:table>
		
		
		
		<fo:table table-layout="fixed" width="100%">
			<fo:table-column column-width="2.2cm" />
			<fo:table-column column-width="2.7cm" />
			<fo:table-column column-width="1.5cm" />
			<fo:table-column column-width="4.3cm" />
			<fo:table-column column-width="proportional-column-width(1)" />
			<fo:table-body>
				<fo:table-row>
					<fo:table-cell>
						<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
						Postnr.
						</fo:block>
					</fo:table-cell>
					<fo:table-cell>
						<fo:block padding="2pt" margin-bottom="2pt" background-color="#FFFFFF">
							<xsl:value-of select="postCode"/><fo:inline> </fo:inline>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell>
						<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
						Poststed
						</fo:block>
					</fo:table-cell>
					<fo:table-cell>
						<fo:block padding="2pt" margin-bottom="2pt" background-color="#FFFFFF"  >
							<xsl:value-of select="postCity"/><fo:inline> </fo:inline>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell>
						<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
						</fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-body>
		</fo:table>
	</xsl:template>
	
	
	
	
	<!--  .................. ............................................................................>
	<...  broker PART end   ............................................................................>
	<...  .................. ..........................................................................-->



</xsl:stylesheet>