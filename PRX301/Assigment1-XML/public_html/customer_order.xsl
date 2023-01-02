<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : customer_order.xsl
    Created on : 2 tháng 6, 2022, 17:22
    Author     : Kien
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="customer_order">
        <html>
            <head>
                <title>Customer Order</title>
                <link rel="stylesheet" href="css.css"/>
            </head>
            <body>
                <div class="root">
                    <div class="title">Order detail</div>
                    <div class="right section">
                        <div>Order number: <span class="bold">
                                <xsl:value-of select="@number"/>
                            </span>
                        </div>
                        <div>Date: <span class="bold">
                                <xsl:value-of select="@date"/>
                            </span>
                        </div>
                    </div>
                    <div class="left section">
                        <div>Customer's name: <span class="bold">
                                <xsl:value-of select="customer/name"/>
                            </span>
                        </div>
                        <div>Street: <span class="bold">
                                <xsl:value-of select="customer/street"/>
                            </span>
                        </div>
                        <div>City: <span class="bold">
                                <xsl:value-of select="customer/city"/>
                            </span>
                        </div>
                        <div>Post-code: <span class="bold">
                                <xsl:value-of select="customer/post_code"/>
                            </span>
                        </div>
                    </div>
                    <div class="section">
                        <div>Card issuer: <span class="bold">
                                <xsl:value-of select="payment/card_issuer"/>
                            </span>
                        </div>
                        <div>Card number: <span class="bold">
                                <xsl:value-of select="payment/card_number"/>
                            </span>
                        </div>
                        <div>Expiration date: 
                            <span class="bold">
                                <xsl:value-of select="payment/expiration_date/@month"/>
                                - 
                                <xsl:value-of select="payment/expiration_date/@year"/>
                            </span>
                        </div>
                    </div>
                    <div class="section">
                        <table>                    
                            <thead>
                                <td>No</td>
                                <td>Item</td>                        
                                <td>Quantity</td>                    
                                <td>Price</td>                    
                            </thead>
                            <tbody>
                                <xsl:for-each select="lines/line">
                                    <tr>
                                        <td>
                                            <xsl:value-of select="@no"/>
                                        </td>                            
                                        <td>
                                            <xsl:value-of select="item"/>
                                        </td>                            
                                        <td>
                                            <xsl:value-of select="quantity"/> 
                                        </td>                            
                                        <td>
                                            <xsl:value-of select="price"/>
                                        </td>                       
                                    </tr>                                         
                                </xsl:for-each>        
                            </tbody>                   
                            
                        </table>           
                    </div>
                </div>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
