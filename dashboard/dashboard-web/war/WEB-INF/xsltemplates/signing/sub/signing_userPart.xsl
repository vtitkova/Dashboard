<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format"
	exclude-result-prefixes="fo">
	<xsl:output method="xml" version="1.0" omit-xml-declaration="no"
		indent="yes" />
	<xsl:param name="versionParam" select="'1.0'" />

	<!-- .................. ............................................................................> 
		<... USER PART begin ............................................................................> 
		<... .................. .......................................................................... -->
	<xsl:template match="userPart">
		<fo:block margin-top="15px" margin-left="10px">
			<fo:inline>Dato og sted: </fo:inline>
			<fo:inline border-bottom-style="solid" border-bottom-color="#E7E7E8"
				border-bottom-width="1pt">                       
				                                                                  
			</fo:inline>
		</fo:block>
		<fo:table margin-top="10px" table-layout="fixed" width="100%"
			border="1pt solid #E7E7E8" background-color="#e6f4fd">
			<fo:table-column column-width="100%" />
			<fo:table-body>
				<fo:table-row>
					<fo:table-cell display-align="center" padding=" 3 5 3 5 ">
						<xsl:call-template name="createUserTable" />
					</fo:table-cell>
				</fo:table-row>
			</fo:table-body>
		</fo:table>
	</xsl:template>


	<!-- .................. ............................................................................> 
		<... USER PART end ............................................................................> 
		<... .................. .......................................................................... -->
	<xsl:template name="createUserTable">
		<fo:table table-layout="fixed" width="100%">
			<fo:table-column column-width="2.2cm" />

			<fo:table-column column-width="1.7cm" />
			<fo:table-column column-width="1.5cm" />
			<fo:table-column column-width="1.7cm" />
			<fo:table-column column-width="1.5cm" />
			<fo:table-column column-width="1.6cm" />

			<fo:table-column column-width="2.0cm" />

			<fo:table-column column-width="1.8cm" />
			<fo:table-column column-width="0.4cm" />
			<fo:table-column column-width="proportional-column-width(1)" />
			<fo:table-body>
				<xsl:call-template name="createUserTableRows" />
			</fo:table-body>
		</fo:table>
	</xsl:template>

	<xsl:template match="userLines">
		<xsl:apply-templates select="UserLine" />
	</xsl:template>

	<xsl:template match="UserLine">
		<!-- first User -->
		<fo:table-row>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					Navn
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="5">
				<fo:block padding="2pt" margin-bottom="2pt"
					background-color="#FFFFFF">
					<xsl:value-of select="name" />
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					Person nr.
				</fo:block>
			</fo:table-cell>
			<xsl:apply-templates select="personalNumber" />

		</fo:table-row>
		<fo:table-row>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					Underskrift
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="5">
				<fo:block padding="2pt" margin-bottom="2pt"
					background-color="#FFFFFF">
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="3">
				<fo:block padding="2pt" margin-bottom="2pt">
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>
		</fo:table-row>
	</xsl:template>

	<xsl:template match="personalNumber">
		<fo:table-cell>
			<fo:block padding="2pt" margin-bottom="2pt"
				background-color="#FFFFFF">
				<xsl:value-of select="birth" />
				<fo:inline> </fo:inline>
			</fo:block>
		</fo:table-cell>
		<fo:table-cell>
			<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
				-
				</fo:block>
		</fo:table-cell>
		<fo:table-cell>
			<fo:block padding="2pt" margin-bottom="2pt"
				background-color="#FFFFFF">
				<xsl:value-of select="code" />
				<fo:inline> </fo:inline>
			</fo:block>
		</fo:table-cell>
	</xsl:template>



	<xsl:template name="createUserTableRows">
		<xsl:apply-templates select="userLines" />



		<!-- Address -->
		<fo:table-row>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					Adr.
				</fo:block>
			</fo:table-cell>


			<fo:table-cell number-columns-spanned="5">
				<fo:block padding="2pt" margin-bottom="2pt"
					background-color="#FFFFFF">
					<xsl:value-of select="address" />
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>


			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					Postnr.
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="3">
				<fo:block padding="2pt" margin-bottom="2pt"
					background-color="#FFFFFF">
					<xsl:value-of select="postCode" />
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>
		</fo:table-row>


		<!-- Phones & email -->
		<fo:table-row>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					Tlf. arb.
				</fo:block>
			</fo:table-cell>

			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt"
					background-color="#FFFFFF">
					<xsl:value-of select="phoneWork" />
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>



			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					Mob.tlf.
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt"
					background-color="#FFFFFF">
					<xsl:value-of select="phoneMob" />
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					Tlf.priv.
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt"
					background-color="#FFFFFF">
					<xsl:value-of select="phonePrivate" />
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>

			<fo:table-cell>
				<fo:block padding="2pt" margin-bottom="2pt" margin-left="3pt">
					E-post
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="3">
				<fo:block padding="2pt" margin-bottom="2pt"
					background-color="#FFFFFF">
					<xsl:value-of select="email" />
					<fo:inline> </fo:inline>
				</fo:block>
			</fo:table-cell>
		</fo:table-row>



	</xsl:template>


</xsl:stylesheet>