
public enum ProfileType {
	/* for internal usage */
	INVALID_PROFILE_PARAM(0, "Invalid", false),

	/* Technology specific params - 3GPP */
	/* *************************************/  
	TECH_3GPP_PROFILE_PARAM_MIN(0x10, "Profile Param MIN", false),

	TECH_3GPP_PROFILE_PARAM_PDP_CONTEXT_PDP_TYPE(0x1, TECH_3GPP_PROFILE_PARAM_MIN, "PDP Type"),
	/**< PDP context type. */
	TECH_3GPP_PROFILE_PARAM_PDP_CONTEXT_H_COMP(0x2, TECH_3GPP_PROFILE_PARAM_MIN, "H Comp"),
	/**< PDP header compression support. */
	TECH_3GPP_PROFILE_PARAM_PDP_CONTEXT_D_COMP(0x3, TECH_3GPP_PROFILE_PARAM_MIN, "D Comp"),
	/**< PDP data compression support. */  
	TECH_3GPP_PROFILE_PARAM_DNS_ADDR_V4_PRIMARY(0x5, TECH_3GPP_PROFILE_PARAM_MIN, "DNS Addr V4 Primary"),
	/**< Primary IPv4 DNS address. */
	TECH_3GPP_PROFILE_PARAM_DNS_ADDR_V4_SECONDARY(0x6, TECH_3GPP_PROFILE_PARAM_MIN, "DNS Addr V4 Secondary"),
	/**< Secondary IPv4 DNS address. */
	TECH_3GPP_PROFILE_PARAM_UMTS_REQ_QOS_EXTENDED(0x7, TECH_3GPP_PROFILE_PARAM_MIN, "Req QOS Extended"), 
	/**< Internal use only. */
	TECH_3GPP_PROFILE_PARAM_UMTS_MIN_QOS_EXTENDED(0x8, TECH_3GPP_PROFILE_PARAM_MIN, "MIN QOS Extended"),
	/**< Internal use only. */
	TECH_3GPP_PROFILE_PARAM_GPRS_REQ_QOS       (0x9, TECH_3GPP_PROFILE_PARAM_MIN, "GPRS Req QOS"),
	/**< GPRS QoS request. */
	TECH_3GPP_PROFILE_PARAM_GPRS_MIN_QOS       (0xA, TECH_3GPP_PROFILE_PARAM_MIN, "GPRS MIN QOS"),
	/**< GPRS minimum QoS request. */
	TECH_3GPP_PROFILE_PARAM_AUTH_USERNAME      (0xB, TECH_3GPP_PROFILE_PARAM_MIN, "Auth Username"),
	/**< PDP authentication username. */
	TECH_3GPP_PROFILE_PARAM_AUTH_PASSWORD      (0xC, TECH_3GPP_PROFILE_PARAM_MIN, "Auth Password"),
	/**< PDP authentication password. */
	TECH_3GPP_PROFILE_PARAM_AUTH_TYPE          (0xD, TECH_3GPP_PROFILE_PARAM_MIN, "Auth Type"),
	/**< PDP authentication type. */
	TECH_3GPP_PROFILE_PARAM_PDP_CONTEXT_PDP_ADDR_V4(0xE, TECH_3GPP_PROFILE_PARAM_MIN, "PDP ADDR V4"),
	/**< IPv4 address in PDP context. */
	TECH_3GPP_PROFILE_PARAM_PCSCF_REQ_FLAG     (0xF, TECH_3GPP_PROFILE_PARAM_MIN, "PCSCF Req Flag"),
	/**< PCSCF request flag. */
	TECH_3GPP_PROFILE_PARAM_PDP_CONTEXT_TE_MT_ACCESS_CTRL_FLAG (0x10, TECH_3GPP_PROFILE_PARAM_MIN, "TE MT Access Ctrl Flag"),
	/**< Mobile Terminated Access Control flag. */
	TECH_3GPP_PROFILE_PARAM_PCSCF_DHCP_REQ_FLAG(0x11, TECH_3GPP_PROFILE_PARAM_MIN, "PCSCF DHCP Req Flag"),
	/**< PCSCF request using the DHCP flag. */
	TECH_3GPP_PROFILE_PARAM_IM_CN_FLAG         (0x12, TECH_3GPP_PROFILE_PARAM_MIN, "IM CN Flag"),
	/**< IP Multimedia Core Network flag. */
	TECH_3GPP_PROFILE_PARAM_TFT_FILTER_ID1     (0x13, TECH_3GPP_PROFILE_PARAM_MIN, "TFT Filter ID1"),
	/**< TFT filter ID 1. */
	TECH_3GPP_PROFILE_PARAM_TFT_FILTER_ID2     (0x14, TECH_3GPP_PROFILE_PARAM_MIN, "TFT Filter ID2"),
	/**< TFT filter ID 2. */
	TECH_3GPP_PROFILE_PARAM_PDP_CONTEXT_NUMBER (0x15, TECH_3GPP_PROFILE_PARAM_MIN, "PDP Context Number"),
	/**< PDP context number. */
	TECH_3GPP_PROFILE_PARAM_PDP_CONTEXT_SECONDARY_FLAG(0x16, TECH_3GPP_PROFILE_PARAM_MIN, "PDP Context Secondary Flag"),
	/**< Secondary PDP context flag. */
	TECH_3GPP_PROFILE_PARAM_PDP_CONTEXT_PRIMARY_ID (0x17, TECH_3GPP_PROFILE_PARAM_MIN, "PDP Context Primary ID"),
	/**< Primary PDP context ID. */
	TECH_3GPP_PROFILE_PARAM_PDP_CONTEXT_PDP_ADDR_V6(0x18, TECH_3GPP_PROFILE_PARAM_MIN, "PDP Addr V6"),
	/**< IPv6 address in PDP context. */
	TECH_3GPP_PROFILE_PARAM_UMTS_REQ_QOS       (0x19, TECH_3GPP_PROFILE_PARAM_MIN, "UMTS Req QOS"),
	/**< Request UMTS QoS. */
	TECH_3GPP_PROFILE_PARAM_UMTS_MIN_QOS       (0x1A, TECH_3GPP_PROFILE_PARAM_MIN, "UMTS MIN QOS"),
	/**< Request for minimum UMTS QoS. */
	TECH_3GPP_PROFILE_PARAM_DNS_ADDR_V6_PRIMARY(0x1B, TECH_3GPP_PROFILE_PARAM_MIN, "DNS Addr V6 Primary"),
	/**< Primary IPv6 DNS address. */
	TECH_3GPP_PROFILE_PARAM_DNS_ADDR_V6_SECONDARY(0x1C, TECH_3GPP_PROFILE_PARAM_MIN, "DNS Addr V6 Secondary"),
	/**< Secondary IPv6 DNS address. */
	TECH_3GPP_PROFILE_PARAM_IPV4_ADDR_ALLOC    (0x1D, TECH_3GPP_PROFILE_PARAM_MIN, "IPV4 Addr Alloc"),
	/**< IPv4 address allocation. */
	TECH_3GPP_PROFILE_PARAM_LTE_REQ_QOS        (0x1E, TECH_3GPP_PROFILE_PARAM_MIN, "LTE Req QOS"),
	/**< Request LTE QoS. */
	TECH_3GPP_PROFILE_PARAM_APN_DISABLE_FLAG   (0x1F, TECH_3GPP_PROFILE_PARAM_MIN, "APN Disable Flag"),
	/**< APN Disable flag. */
	TECH_3GPP_PROFILE_PARAM_INACTIVITY_TIMER_VAL (0x20, TECH_3GPP_PROFILE_PARAM_MIN, "Inactivity Timer"),
	/**< APN inactivity timer value. */  
	TECH_3GPP_PROFILE_PARAM_APN_CLASS          (0x21, TECH_3GPP_PROFILE_PARAM_MIN, "APN Class"),
	/**< APN class parameter. */
	TECH_3GPP_PROFILE_PARAM_LINGER_PARAMS      (0x22, TECH_3GPP_PROFILE_PARAM_MIN, "Linger Parmas"),
	/**< Iface linger parameter */
	TECH_3GPP_PROFILE_PARAM_SRC_STAT_DESC_REQ  (0x23, TECH_3GPP_PROFILE_PARAM_MIN, "Src Stat Desc Req"),
	/**< Source statistics descriptor for requested UMTS QoS. */
	TECH_3GPP_PROFILE_PARAM_SRC_STAT_DESC_MIN  (0x24, TECH_3GPP_PROFILE_PARAM_MIN, "Src Stat Desc Min"),
	/**< Source Statistics Descriptor for minimum UMTS QoS. */
	TECH_3GPP_PROFILE_PARAM_APN_BEARER         (0x25, TECH_3GPP_PROFILE_PARAM_MIN, "APN Bearer"),
	/** < APN bearer type specifier */
	TECH_3GPP_PROFILE_PARAM_EMERGENCY_CALLS_SUPPORTED (0x26, TECH_3GPP_PROFILE_PARAM_MIN, "Emergency Calls Supported"),
	/**< Flag used to identify is emergency calls can be made using this profile. */
	TECH_3GPP_PROFILE_PARAM_OPERATOR_RESERVED_PCO(0x27, TECH_3GPP_PROFILE_PARAM_MIN, "Operator Reserved PCO"),  
	/** OPERATOR RESERVED PCO */
	TECH_3GPP_PROFILE_PARAM_MCC                (0x28, TECH_3GPP_PROFILE_PARAM_MIN, "MCC"),
	 /** MCC */
	TECH_3GPP_PROFILE_PARAM_MNC                (0x29, TECH_3GPP_PROFILE_PARAM_MIN, "MNC"),
	 /** MNC */
	TECH_3GPP_PROFILE_PARAM_MAX_PDN_CONN_PER_BLOCK (0x2A, TECH_3GPP_PROFILE_PARAM_MIN, "Max PDN Conn Per Block"),  
	/** Max PDN Connections per Time Block */
	TECH_3GPP_PROFILE_PARAM_MAX_PDN_CONN_TIMER (0x2B, TECH_3GPP_PROFILE_PARAM_MIN, "Max PDN Conn Timer"),
	/** Max PDN Connection Time */
	TECH_3GPP_PROFILE_PARAM_PDN_REQ_WAIT_TIMER (0x2C, TECH_3GPP_PROFILE_PARAM_MIN, "PDN Req Wait Timer"),
	/** PDN Request Wait Time */
	TECH_3GPP_PROFILE_PARAM_USER_APP_DATA      (0x2D, TECH_3GPP_PROFILE_PARAM_MIN, "User App Data"),
	/** Application/User Data */
	TECH_3GPP_PROFILE_PARAM_ROAMING_DISALLOWED (0x2E, TECH_3GPP_PROFILE_PARAM_MIN, "Roaming Disallowed"),
	/** Roaming enable/disable flag */
	TECH_3GPP_PROFILE_PARAM_PDN_DISCON_WAIT_TIME (0x2F, TECH_3GPP_PROFILE_PARAM_MIN, "PDN Discon Wait Timer"),
	/** PDN disconnectivity wait time */
	TECH_3GPP_PROFILE_PARAM_DNS_DHCP_REQ_FLAG  (0x30, TECH_3GPP_PROFILE_PARAM_MIN, "DNS DHCP Req Flag"),
	/**< DNS request using the DHCP flag. */
	TECH_3GPP_PROFILE_PARAM_LTE_ROAMING_PDP_TYPE (0x31, TECH_3GPP_PROFILE_PARAM_MIN, "LTE Roaming PDP Type"),
	/**< LTE Roaming PDP context type*/
	TECH_3GPP_PROFILE_PARAM_UMTS_ROAMING_PDP_TYPE(0x32, TECH_3GPP_PROFILE_PARAM_MIN, "UMTS Roaming PDP Type"),
	/**< UMTS Roaming PDP context type*/
	TECH_3GPP_PROFILE_PARAM_IWLAN_TO_LTE_ROAMING_HO_FLAG ( 0x33, TECH_3GPP_PROFILE_PARAM_MIN, "LTE Roaming HO Flag"),
	/**< Roaming handover from IWLAN to LTE allowed flag*/
	TECH_3GPP_PROFILE_PARAM_LTE_TO_IWLAN_ROAMING_HO_FLAG ( 0x34, TECH_3GPP_PROFILE_PARAM_MIN, "IWLAN Roaming HO Flag"),
	/**< Roaming handover from LTE to IWLAN allowed flag*/
	TECH_3GPP_PROFILE_PARAM_FAILURE_TIMERS     (0x35, TECH_3GPP_PROFILE_PARAM_MIN, "Failure Timers"),
	/**< PDN Failure Throttle Timers */
	TECH_3GPP_PROFILE_PARAM_OVERRIDE_HOME_PDP_TYPE (0x36, TECH_3GPP_PROFILE_PARAM_MIN, "Override Home PDP Type"),
	/**< PDN Type override for home PDP type*/
	TECH_3GPP_PROFILE_PARAM_MAX                (TECH_3GPP_PROFILE_PARAM_OVERRIDE_HOME_PDP_TYPE, "Profile Param MAX", false),
	/* Make sure ranges do not overlap ! */

	/* Technology specific params - 3GPP2 */
	/* *************************************/
	/* Make sure ranges do not overlap ! */
	TECH_3GPP2_PROFILE_PARAM_MIN               (0x90, "3GPP2 Profile Param MIN", false),

	TECH_3GPP2_PROFILE_PARAM_NEGOTIATE_DNS_SERVER(0x0, TECH_3GPP2_PROFILE_PARAM_MIN, "Negotiate DNS Server"),                                     
	/**< Negotiate the DNS server. */
	TECH_3GPP2_PROFILE_PARAM_SESSION_CLOSE_TIMER_DO(0x1, TECH_3GPP2_PROFILE_PARAM_MIN, "Session Close Timer DO"),                                     
	/**< PPP session close timer DO. */
	TECH_3GPP2_PROFILE_PARAM_SESSION_CLOSE_TIMER_1X(0x2, TECH_3GPP2_PROFILE_PARAM_MIN, "Session Close Timer 1X"),                                     
	/**< PPP session close timer 1x. */
	TECH_3GPP2_PROFILE_PARAM_ALLOW_LINGER      (0x3, TECH_3GPP2_PROFILE_PARAM_MIN, "Allow Linger"),                                    
	/**< Allow linger. */
	TECH_3GPP2_PROFILE_PARAM_LCP_ACK_TIMEOUT   (0x4, TECH_3GPP2_PROFILE_PARAM_MIN, "LCP ACK Timeout"),                                     
	/**< LCP acknowledge timeout. */
	TECH_3GPP2_PROFILE_PARAM_IPCP_ACK_TIMEOUT  (0x5, TECH_3GPP2_PROFILE_PARAM_MIN, "IPCP ACK Timeout"),
	/**< IPCP acknowledge timeout. */
	TECH_3GPP2_PROFILE_PARAM_AUTH_TIMEOUT      (0x6, TECH_3GPP2_PROFILE_PARAM_MIN, "Auth Timeout"),                                     
	/**< Authentication timeout. */
	TECH_3GPP2_PROFILE_PARAM_LCP_CREQ_RETRY_COUNT(0x7, TECH_3GPP2_PROFILE_PARAM_MIN, "LCP Creq Retry Count"),                                     
	/**< LCP configuration request count. */
	TECH_3GPP2_PROFILE_PARAM_IPCP_CREQ_RETRY_COUNT (0x8, TECH_3GPP2_PROFILE_PARAM_MIN, "IPCP Creq Retry Count"),                                     
	/**< IPCP configuration request count. */
	TECH_3GPP2_PROFILE_PARAM_AUTH_RETRY_COUNT  (0x9, TECH_3GPP2_PROFILE_PARAM_MIN, "Auth Retry Count"),                                     
	/**< Authentication retry count. */
	TECH_3GPP2_PROFILE_PARAM_AUTH_PROTOCOL     (0xA, TECH_3GPP2_PROFILE_PARAM_MIN, "Auth Protocol"),
	/**< Authentication protocol. */
	TECH_3GPP2_PROFILE_PARAM_USER_ID           (0xB, TECH_3GPP2_PROFILE_PARAM_MIN, "User ID"),
	/**< User ID. */
	TECH_3GPP2_PROFILE_PARAM_AUTH_PASSWORD     (0xC, TECH_3GPP2_PROFILE_PARAM_MIN, "AUTH Password"),
	/**< Authentication password. */
	TECH_3GPP2_PROFILE_PARAM_DATA_RATE         (0xD, TECH_3GPP2_PROFILE_PARAM_MIN, "Data Rate"),                                     
	/**< Data rate. */
	TECH_3GPP2_PROFILE_PARAM_DATA_MODE         (0xF, TECH_3GPP2_PROFILE_PARAM_MIN, "Data Mode"),                                     
	/**< Data mode. */
	TECH_3GPP2_PROFILE_PARAM_APP_TYPE          (0xE, TECH_3GPP2_PROFILE_PARAM_MIN, "APP Type"),                                     
	/**< Application type. */
	TECH_3GPP2_PROFILE_PARAM_APP_PRIORITY      (0x10, TECH_3GPP2_PROFILE_PARAM_MIN, "APP Priority"),   
	/**< Application priority. */
	TECH_3GPP2_PROFILE_PARAM_PDN_TYPE          (0x12, TECH_3GPP2_PROFILE_PARAM_MIN, "PDN Type"),                                     
	/**< PDN type. */
	TECH_3GPP2_PROFILE_PARAM_IS_PCSCF_ADDR_NEEDED(0x13, TECH_3GPP2_PROFILE_PARAM_MIN, "PCSCF Addr Needed"),    
	/**< Indicates whether the PCSCF address is needed. */
	TECH_3GPP2_PROFILE_PARAM_V4_DNS_ADDR_PRIMARY (0x14, TECH_3GPP2_PROFILE_PARAM_MIN, "V4 DNS Addr Primary"), 
	/**< IPv4 primary DNS address. */
	TECH_3GPP2_PROFILE_PARAM_V4_DNS_ADDR_SECONDARY (0x15, TECH_3GPP2_PROFILE_PARAM_MIN, "V4 DNS Addr Secondary"),
	/**< IPv4 secondary DNS address. */
	TECH_3GPP2_PROFILE_PARAM_V6_DNS_ADDR_PRIMARY (0x16, TECH_3GPP2_PROFILE_PARAM_MIN, "V6 DNS Addr Primary"),
	/**< IPv6 primary DNS address. */
	TECH_3GPP2_PROFILE_PARAM_V6_DNS_ADDR_SECONDARY (0x17, TECH_3GPP2_PROFILE_PARAM_MIN, "V6 DNS Addr Secondary"),
	/**< IPv6 secondary DNS address. */
	TECH_3GPP2_PROFILE_PARAM_RAT_TYPE          (0x18, TECH_3GPP2_PROFILE_PARAM_MIN, "RAT Type"),                                     
	/**< RAT type. */
	TECH_3GPP2_PROFILE_PARAM_APN_ENABLED       (0x19, TECH_3GPP2_PROFILE_PARAM_MIN, "3GPP2 APN Enabled"),
	/**< APN enabled. */
	TECH_3GPP2_PROFILE_PARAM_PDN_INACTIVITY_TIMEOUT(0x1A, TECH_3GPP2_PROFILE_PARAM_MIN, "PDN Inactivity Timeout"),                                     
	/**< PDN inactivity timeout. */
	TECH_3GPP2_PROFILE_PARAM_APN_CLASS         (0x1B, TECH_3GPP2_PROFILE_PARAM_MIN, "3GPP2 APN Class"),
	/**< APN class. */
	TECH_3GPP2_PROFILE_PARAM_LINGER_PARAMS     (0x1C, TECH_3GPP2_PROFILE_PARAM_MIN, "3GPP2 Linger"),
	/**< Linger parameter. */
	TECH_3GPP2_PROFILE_PARAM_PDN_LEVEL_AUTH_PROTOCOL  (0x1D, TECH_3GPP2_PROFILE_PARAM_MIN, "PDN Level Auth Protocol"),                                     
	/**< PDN Level Authentication Protocol Type */
	TECH_3GPP2_PROFILE_PARAM_PDN_LEVEL_USER_ID (0x1E, TECH_3GPP2_PROFILE_PARAM_MIN, "PDN Level User ID"),                                     
	/**< PDN Level Authentication User ID */
	TECH_3GPP2_PROFILE_PARAM_PDN_LEVEL_AUTH_PASSWORD  (0x1F, TECH_3GPP2_PROFILE_PARAM_MIN, "PDN Level Auth Password"),                                     
	/**< PDN Level Authentication Password */
	TECH_3GPP2_PROFILE_PARAM_PDN_LABEL         (0x20, TECH_3GPP2_PROFILE_PARAM_MIN, "PDN Label"),                                    
	/**< PDN Label */  
	TECH_3GPP2_PROFILE_PARAM_FAILURE_TIMER_1   (0x21, TECH_3GPP2_PROFILE_PARAM_MIN, "Failure Timer 1"),                                    
	/**< PDN Failure Throttle Timer 1 */
	TECH_3GPP2_PROFILE_PARAM_FAILURE_TIMER_2   (0x22, TECH_3GPP2_PROFILE_PARAM_MIN, "Failure Timer 2"),                                     
	/**< PDN Failure Throttle Timer 2 */
	TECH_3GPP2_PROFILE_PARAM_FAILURE_TIMER_3   (0x23, TECH_3GPP2_PROFILE_PARAM_MIN, "Failure Timer 3"),                     
	/**< PDN Failure Throttle Timer 3 */
	TECH_3GPP2_PROFILE_PARAM_FAILURE_TIMER_4   (0x24, TECH_3GPP2_PROFILE_PARAM_MIN, "Failure Timer 4"),                                     
	/**< PDN Failure Throttle Timer 4 */
	TECH_3GPP2_PROFILE_PARAM_FAILURE_TIMER_5   (0x25, TECH_3GPP2_PROFILE_PARAM_MIN, "Failure Timer 5"),                                     
	/**< PDN Failure Throttle Timer 5 */
	TECH_3GPP2_PROFILE_PARAM_FAILURE_TIMER_6   (0x26, TECH_3GPP2_PROFILE_PARAM_MIN, "Failure Timer 6"),                                     
	/**< PDN Failure Throttle Timer 6 */
	TECH_3GPP2_PROFILE_PARAM_DISALLOW_TIMER_1  (0x27, TECH_3GPP2_PROFILE_PARAM_MIN, "Disallow Timer 1"),                                     
	/**< PDN Disallow Throttle Timer 1 */
	TECH_3GPP2_PROFILE_PARAM_DISALLOW_TIMER_2  (0x28, TECH_3GPP2_PROFILE_PARAM_MIN, "Disallow Timer 2"),                                     
	/**< PDN Disallow Throttle Timer 2 */
	TECH_3GPP2_PROFILE_PARAM_DISALLOW_TIMER_3  (0x29, TECH_3GPP2_PROFILE_PARAM_MIN, "Disallow Timer 3"),                                     
	/**< PDN Disallow Throttle Timer 3 */
	TECH_3GPP2_PROFILE_PARAM_DISALLOW_TIMER_4  (0x2A, TECH_3GPP2_PROFILE_PARAM_MIN, "Disallow Timer 4"),                                     
	/**< PDN Disallow Throttle Timer 4 */
	TECH_3GPP2_PROFILE_PARAM_DISALLOW_TIMER_5  (0x2B, TECH_3GPP2_PROFILE_PARAM_MIN, "Disallow Timer 5"),                                     
	/**< PDN Disallow Throttle Timer 5 */
	TECH_3GPP2_PROFILE_PARAM_DISALLOW_TIMER_6  (0x2C, TECH_3GPP2_PROFILE_PARAM_MIN, "Disallow Timer 6"),                                     
	/**< PDN Disallow Throttle Timer 6 */
	TECH_3GPP2_PROFILE_PARAM_OP_PCO_ID         (0x2D, TECH_3GPP2_PROFILE_PARAM_MIN, "3GPP2 OP PCO ID"),    
	/**< Operator Reserved PCO ID  */
	TECH_3GPP2_PROFILE_PARAM_MCC               (0x2E, TECH_3GPP2_PROFILE_PARAM_MIN, "3GPP2 MCC"),
	TECH_3GPP2_PROFILE_PARAM_MNC               (0x2F, TECH_3GPP2_PROFILE_PARAM_MIN, "3GPP2 MNC"),
	TECH_3GPP2_PROFILE_PARAM_FAILURE_TIMERS    (0x30, TECH_3GPP2_PROFILE_PARAM_MIN, "3GPP2 Failure Timers"),
	/**< PDN Failure Throttle Timers */
	TECH_3GPP2_PROFILE_PARAM_DISALLOW_TIMERS   (0x31, TECH_3GPP2_PROFILE_PARAM_MIN, "3GPP2 Disallow Timers"), 
	/**< PDN Disallow Throttle Timers */
	TECH_3GPP2_PROFILE_PARAM_USER_APP_DATA     (0x32, TECH_3GPP2_PROFILE_PARAM_MIN, "User APP Data"),
	/**< 4 byte opaque data */
	TECH_3GPP2_PROFILE_PARAM_PCSCF_DHCP_REQ_FLAG (0x33, TECH_3GPP2_PROFILE_PARAM_MIN, "3GPP2 PCSCF DHCP Req Flag"),
	/**< Indicates if P-CSCF address is requested via DHCP. */
	TECH_3GPP2_PROFILE_PARAM_DNS_DHCP_REQ_FLAG (0x34, TECH_3GPP2_PROFILE_PARAM_MIN, "3GPP2 DNS DHCP Req Flag"),
	/**< Indicates if DNS address is requested via DHCP. */
	TECH_3GPP2_PROFILE_PARAM_MAX               (0xC4, "3GPP2 Profile Param MAX", false),
	/* Make sure ranges do not overlap ! */


	/* Common technology params that can be common and can be overwritten in complex profile types (i.e EPC)
	   * Important *, new params should be added in the beginning by decrementing 
	   COMMON_TECH_PARAM_MIN and adjusting other offsets*/
	/* *************************************/
	/* Make sure ranges do not overlap ! */
	COMMON_TECH_PARAM_MIN                      (0x7D, "Common Tech Param MIN", false),

	COMMON_TECH_PROFILE_PARAM_PCSCF_DHCP_REQ_FLAG(0x0, COMMON_TECH_PARAM_MIN, "Common Tech PCSCF DHCP Req Flag"),
	/** Indicates if P-CSCF address is requested via DHCP. */
	COMMON_TECH_PROFILE_PARAM_DNS_DHCP_REQ_FLAG(0x1, COMMON_TECH_PARAM_MIN, "Common Tech DNS DHCP Req Flag"),
	/** Indicates if DNS address is requested via DHCP. */
	COMMON_TECH_PROFILE_PARAM_PDP_TYPE         (0x2, COMMON_TECH_PARAM_MIN, "Common Tech PDP Type"),
	/** Common PDP Type */
	COMMON_TECH_PROFILE_PARAM_USER_APP_DATA    (0x3, COMMON_TECH_PARAM_MIN, "Common Tech User APP Data"),
	/** 4 byte opaque data */
	COMMON_TECH_PROFILE_PARAM_MNC              (0x4, COMMON_TECH_PARAM_MIN, "Common Tech MNC"),
	/** MNC */
	COMMON_TECH_PROFILE_PARAM_MCC              (0x5, COMMON_TECH_PARAM_MIN, "Common Tech MCC"),
	/** MCC */
	COMMON_TECH_PROFILE_PARAM_OPERATOR_RESERVED_PCO(0x6, COMMON_TECH_PARAM_MIN, "Operator Reserved PCO"),
	/** OPERATOR RESERVED PCO */
	COMMON_TECH_PROFILE_PARAM_AUTH_PASSWORD    (0x7, COMMON_TECH_PARAM_MIN, "Common Tech Auth Password"),
	/**< PDP authentication password. */
	COMMON_TECH_PROFILE_PARAM_AUTH_USERNAME    (0x8, COMMON_TECH_PARAM_MIN, "Common Tech Auth Username"),
	/**< PDP authentication username. */
	COMMON_TECH_PROFILE_PARAM_AUTH_TYPE        (0x9, COMMON_TECH_PARAM_MIN, "Common Tech Auth Type"),
	/**< PDP authentication type. */
	COMMON_TECH_PROFILE_PARAM_PCSCF_REQ_FLAG   (0xA, COMMON_TECH_PARAM_MIN, "Common Tech PCSCF Req Flag"),
	/**< PCSCF request flag. */
	COMMON_TECH_PROFILE_PARAM_LINGER_PARAMS    (0xB, COMMON_TECH_PARAM_MIN, "Common Tech Linger"),
	/**< Iface linger parameter */    
	COMMON_TECH_PROFILE_PARAM_DNS_ADDR_V6_SECONDARY(0xC, COMMON_TECH_PARAM_MIN, "Common Tech DNS Addr V6 Secondary"),
	/**< Secondary IPv6 DNS address. */   
	COMMON_TECH_PROFILE_PARAM_DNS_ADDR_V6_PRIMARY(0xD, COMMON_TECH_PARAM_MIN, "Common Tech DNS Addr V6 Primary"),
	/**< Primary IPv6 DNS address. */    
	COMMON_TECH_PROFILE_PARAM_DNS_ADDR_V4_SECONDARY(0xE, COMMON_TECH_PARAM_MIN, "Common Tech DNS Addr V4 Secondary"),
	/**< Secondary IPv4 DNS address. */    
	COMMON_TECH_PROFILE_PARAM_DNS_ADDR_V4_PRIMARY(0xF, COMMON_TECH_PARAM_MIN, "Common Tech DNS Addr V4 Primary"),  
	/**< Primary IPv4 DNS address. */    
	COMMON_TECH_PROFILE_PARAM_APN_CLASS        (0x10, COMMON_TECH_PARAM_MIN, "Common Tech APN Class"),
	/**< APN class parameter. */    
	COMMON_TECH_PROFILE_PARAM_APN_DISABLE_FLAG (0x11, COMMON_TECH_PARAM_MIN, "Common Tech APN Disable Flag"),
	/**< APN Disable flag. */


	COMMON_TECH_PARAM_MAX                      (0x8E, "Common Tech Param MAX", false),
	/* Make sure ranges do not overlap ! */


	/* General Params used in all profiles */
	/* *************************************/
	/* currently there is no representation for those in legacy ds profile */
	GENERAL_PROFILE_PARAM_MIN                  (0x1000, "Generral Profile Param MIN", false),

	GENERAL_PROFILE_PARAM_PROFILE_NAME         (0x0, GENERAL_PROFILE_PARAM_MIN, "Profile Name"),
	/**< Profile name. */
	GENERAL_PROFILE_PARAM_APN_NAME             (0x1, GENERAL_PROFILE_PARAM_MIN, "APN Name"),
	/**< access point name. */
	GENERAL_PROFILE_PARAM_SUBS_ID              (0x2, GENERAL_PROFILE_PARAM_MIN, "Subs ID"),
	/** SUBS ID */
	GENERAL_PROFILE_PARAM_IPV6_DELEGATION      (0x03, GENERAL_PROFILE_PARAM_MIN, "IPV6 Delegation"),
	/** IPV6 Delegation */
	GENERAL_PROFILE_PARAM_ATTACH_PROFILE_FLAG  (0x04, GENERAL_PROFILE_PARAM_MIN, "Attach Profile Flag"),
	/** Attach Profile Flag */
	GENERAL_PROFILE_PARAM_CLAT_ENABLE_FLAG     (0x05, GENERAL_PROFILE_PARAM_MIN, "Clat Enable Flag"),
	/** XLAT Enabled Flag */
	GENERAL_PROFILE_PARAM_MAX                  (GENERAL_PROFILE_PARAM_CLAT_ENABLE_FLAG, "Generral Profile Param MAX", false);
	
	private final int key;
	private final String label;
	private final Boolean isKey;

	private ProfileType(int key) {
		this.key = key;
		this.label = "N/A";
		isKey = false;
	}

	private ProfileType(int key, String label) {
		this.key = key;
		this.label = label;
		isKey = true;
	}

	private ProfileType(int key, String label, Boolean isKey) {
		this.key = key;
		this.label = label;
		this.isKey = isKey;
	}
	
	private ProfileType(int key, ProfileType offset) {
		this.key = key + offset.getTypeKey();
		this.label = "N/A";
		isKey = true;
	}

	private ProfileType(int key, ProfileType offset, String label) {
		this.key = key + offset.getTypeKey();
		this.label = label;
		isKey = true;
	}
	
	private ProfileType(ProfileType offset) {
		this.key = offset.getTypeKey();
		this.label = "N/A";
		isKey = true;
	}
	
	private ProfileType(ProfileType offset, String label) {
		this.key = offset.getTypeKey();
		this.label = label;
		isKey = true;
	}

	private ProfileType(ProfileType offset, String label, Boolean isKey) {
		this.key = offset.getTypeKey();
		this.label = label;
		this.isKey = isKey;
	}
	
	public int getTypeKey() {
		return key;
	}
	
	public String getLabel() {
		return label;
	}
	
	public Boolean isKey() {
		return isKey;
	}
	
	public Boolean is3GPPKey() {
		if(this.isKey && this.key >= TECH_3GPP_PROFILE_PARAM_MIN.getTypeKey() && this.key <= TECH_3GPP_PROFILE_PARAM_MAX.getTypeKey())
			return true;
		else
			return false;
	}
	
	public Boolean is3GPP2Key() {
		if(this.isKey && this.key >= TECH_3GPP2_PROFILE_PARAM_MIN.getTypeKey() && this.key <= TECH_3GPP2_PROFILE_PARAM_MAX.getTypeKey())
			return true;
		else
			return false;
	}
	
	public Boolean isCommonTechKey() {
		if(this.isKey && this.key >= COMMON_TECH_PARAM_MIN.getTypeKey() && this.key <= COMMON_TECH_PARAM_MAX.getTypeKey())
			return true;
		else
			return false;
	}
	
	public Boolean isGeneralKey() {
		if(this.isKey && this.key >= GENERAL_PROFILE_PARAM_MIN.getTypeKey() && this.key <= GENERAL_PROFILE_PARAM_MAX.getTypeKey())
			return true;
		else
			return false;
	}
}