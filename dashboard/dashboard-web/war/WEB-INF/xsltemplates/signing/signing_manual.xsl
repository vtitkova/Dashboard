<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format"
	exclude-result-prefixes="fo">
	<xsl:output method="xml" version="1.0" omit-xml-declaration="no" indent="yes" />
	<xsl:param name="versionParam" select="'1.0'" />
	<xsl:param name="EM1.LOGO"></xsl:param>
	
	<xsl:template match="SigningForm">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
			<fo:layout-master-set>

				<fo:simple-page-master master-name="signing-master-first"
					page-height="29.7cm" page-width="21cm" margin-left="2cm"
					margin-right="2cm">
					<fo:region-body margin-top="2.5cm" margin-bottom="1.5cm"
						column-count="1" />
					<fo:region-before region-name="page-header-first"
						overflow="hidden" extent="90px" />
					<fo:region-after region-name="page-footer-first"
						overflow="hidden" extent="100px" />
				</fo:simple-page-master>

				<fo:simple-page-master master-name="signing-master-other"
					page-height="29.7cm" page-width="21cm" margin-left="2cm"
					margin-right="2cm">
					<fo:region-body margin-top="2cm" margin-bottom="1.5cm"
						column-count="1" />
				</fo:simple-page-master>

				<fo:page-sequence-master master-name="signing-master">
					<fo:repeatable-page-master-alternatives>
						<fo:conditional-page-master-reference
							master-reference="signing-master-first" page-position="first" />
						<fo:conditional-page-master-reference
							master-reference="signing-master-other" />
					</fo:repeatable-page-master-alternatives>
				</fo:page-sequence-master>
			</fo:layout-master-set>

			<!-- document font setup -->
			<fo:page-sequence master-reference="signing-master"
				initial-page-number="1" format="1" font-size="8pt" color="#231F20"
				font-family="Helvetica">
				<fo:static-content flow-name="page-header-first">
					<fo:block-container margin-top="10px">
						<fo:block>
							<!-- background-color="#8057ff" -->
							<fo:table 
							 width="100%"  
								table-layout="fixed" border-spacing="2pt">
								<fo:table-column column-width="proportional-column-width(1)" />
								<fo:table-column column-width="300px" />
								<fo:table-body start-indent="0pt">
									<fo:table-row>
										<fo:table-cell padding="0" display-align="center" 
										 font-size="20pt" color="#00AAE7">
											<fo:block text-align="left" margin-left="15px">
												<xsl:value-of select="header" />
											</fo:block>
										</fo:table-cell>
										<fo:table-cell font-size="10pt" padding="0"
											display-align="center">
											<fo:block text-align="right">
												<fo:external-graphic 
												src="{$EM1.LOGO}"  />
												<fo:inline>
												</fo:inline>
											</fo:block>
										</fo:table-cell>
									</fo:table-row>
								</fo:table-body>
							</fo:table>
						</fo:block>
					</fo:block-container>
				</fo:static-content>

				<fo:static-content flow-name="page-footer-first">
					<fo:block-container height="80.000000px"
						overflow="hidden" display-align="after">
						<fo:block>
							<fo:table width="100%"
								table-layout="fixed" border-spacing="2pt">
								<fo:table-column column-width="100%" />
								<fo:table-body start-indent="0pt">
									<fo:table-row>
										<fo:table-cell font-size="7pt" padding="0"
											display-align="center">
											<fo:block text-align="left">
												<xsl:value-of select="footer" />
												<fo:inline> </fo:inline>
											</fo:block>
										</fo:table-cell>
									</fo:table-row>
								</fo:table-body>
							</fo:table>
						</fo:block>
					</fo:block-container>
				</fo:static-content>

				<fo:flow flow-name="xsl-region-body">
					<xsl:apply-templates select="propertyBid" />
					<xsl:apply-templates select="financingPlan" />
					<xsl:apply-templates select="userPart" />
					<xsl:apply-templates select="brokerPart" />
					<xsl:apply-templates select="terms" />
				</fo:flow>
			</fo:page-sequence>
		</fo:root>

	</xsl:template>

	<xsl:include href="sub/signing_propertyBidPart.xsl"/>                      
	<xsl:include href="sub/signing_financingPart.xsl"/>
	<xsl:include href="sub/signing_userPart.xsl"/>
	<xsl:include href="sub/signing_brokerPart.xsl"/>
	<xsl:include href="sub/signing_termsPart.xsl"/>
	


</xsl:stylesheet>