package in.petalappstudio.savetheinternet;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import org.apache.http.protocol.HTTP;

import java.util.List;
import java.util.Random;

/**
 * Created by vivek on 14/4/15.
 */
public class HomeTab extends Fragment {
    RelativeLayout respondButton, visitWebsite1, visitWebsite2;
    Random r;
    int i;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.home_tab,container,false);
        respondButton=(RelativeLayout)v.findViewById(R.id.respondButton);
        visitWebsite1=(RelativeLayout)v.findViewById(R.id.visitWebsite1);
        visitWebsite2=(RelativeLayout)v.findViewById(R.id.visitWebsite2);
        final PackageManager packageManager = getActivity().getPackageManager();
        respondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
// The intent does not have a URI, so declare the "text/plain" MIME type
                emailIntent.setType(HTTP.PLAIN_TEXT_TYPE);
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"advqos@trai.gov.in"});// recipients
                emailIntent.putExtra(Intent.EXTRA_BCC,new String[]{"netneutralityindia18@gmail.com"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Net Neutrality");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "To the Chairman, TRAI\n" +
                        "\n" +
                        "Thank you for giving me this opportunity to share my views on the consultation paper published by TRAI on March 27, 2015 titled \"Regulatory Framework For Over-the-Top (OTT) Services”. I am worried that this consultation paper makes sweeping assumptions about the Internet, and does not take a neutral and balanced view of the subject of Internet Licensing and Net Neutrality. Any public consultation must be approached in a neutral manner by the regulator, so that people can form an informed opinion.\n" +
                        "\n" +
                        "I strongly support an open internet, for which I believe it is critical to uphold net neutrality and reject any moves towards licensing of Internet applications and Web services.\n" +
                        "\n" +
                        "I urge TRAI to commit to outlining measures to protect and advance net neutrality for all Indians. Net neutrality requires that the Internet be maintained as an open platform, on which network providers treat all content, applications and services equally, without discrimination. The TRAI must give importance to safeguarding the interests of our country’s citizens and the national objective of Digital India and Make In India, over claims made by some corporate interests.\n" +
                        "\n" +
                        "I request that my response be published on the TRAI website alongside other comments filed, in line with past practice regarding public consultations. I urge that TRAI issue a specific response to user submissions after examining the concerns raised by them, and hold open house discussions across India, accessible to users and startups before making any recommendations.\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "Question 1: Is it too early to establish a regulatory framework for Internet/OTT services, since internet penetration is still evolving, access speeds are generally low and there is limited coverage of high-speed broadband in the country? Or, should some beginning be made now with a regulatory framework that could be adapted to changes in the future? Please comment with justifications.\n" +
                        "\n" +
                        "No new regulatory framework in the telecom sector is required for Internet services and apps - and no such regulation should come into effect in future either.\n" +
                        "\n" +
                        "This question incorrectly presumes that regulation of the Internet is absent and there is a need to create it. Additionally, the technical language of “Over-the-Top” applications used in the consultation paper fails to convey that it is truly referring to the online services and applications which make today’s Internet which we all use; Facebook, Ola, Zomato, Paytm, WhatsApp, Zoho and Skype etc. The Internet is already subject to existing law in India - any extra regulatory or licensing regime will only be detrimental to the customer and to Indian firms developing online services and apps.\n" +
                        "\n" +
                        "Under the current regulatory framework, users can access the internet-based services and apps either for a low fee or for free where the application owners make money by selling advertisements based on user data. With additional regulations and licenses, it will make it expensive for these services to reach out to their customers eventually leading to higher prices and undesirable levels of advertising - which is against the public interest and counterproductive.\n" +
                        "\n" +
                        "It appears that the telecom companies are shifting goalposts. Many telecom companies have earlier argued in the consultation paper floated by TRAI on mobile value added services (MVAS) that it was not necessary to regulate these value added services. They said MVAS are already governed by general laws under the Indian legal system and comply with the security interests as they operate on the networks of legitimate telecom license holders. Internet platforms also are regulated and governed by general laws in addition to specialised laws such as the Information Technology Act, and the same treatment should be extended to them as well.\n" +
                        "\n" +
                        "As TRAI said previously in its recommendations after consulting on MVAS regulation:\n" +
                        "\n" +
                        "“The Authority preferred least intrusive and minimal regulatory framework and thus no separate category of licence for value added services is envisaged. After second round of consultations, the Authority is also not favoring registration of Value Added Service Providers (VASPs) or content aggregators under the “Other Service Provider (OSP)” category.”\n" +
                        "\n" +
                        "“Content shall be subject to relevant content regulation and compliance of prevailing copyrights including digital management rights and other laws on the subject (para 3.12.2). The content is subjected to content regulation/ guidelines of Ministry of Information and Broadcasting, Information Technology Act, 2000, Cable Television Networks (Regulation) Act, 1995, Indian Copyright Act etc., as amended from time to time. The content regulation shall be as per law in force from time to time. There should be consistency in the treatment of content across all kinds of media including print, digital/multimedia to avoid any discrimination. (para 3.13.3):”\n" +
                        "\n" +
                        "Imposing a licensing and regulation regime carry significant risks of destroying innovation. Launching new services and features will take more time and will make it difficult for new startups with low cash reserves to enter the market. It will basically ring the death knell for the country's fast-growing digital media sector.\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "Question 2: Should the Internet/OTT players offering communication services (voice, messaging and video call services through applications (resident either in the country or outside) be brought under the licensing regime? Please comment with justifications.\n" +
                        "\n" +
                        "Firstly, there is no need for licensing of internet based communication service providers. To suggest such a move further points towards the TRAI consultation being tilted in favour of telecom operators.\n" +
                        "\n" +
                        "Secondly, fundamentally both Internet-based communication services and non-communication services are the same. They sit on top of the network provided by telecom operators. And the spectrum that telecom operators utilise to offer this network on pipe is already licensed, hence there is no need for additional licensing.\n" +
                        "\n" +
                        "This issue also needs to be looked at from another perspective. Many non-communication services on the Internet also offer real-time chat or video interaction features for the benefit of customers, which will be affected by bringing such services under a licensing regime.\n" +
                        "\n" +
                        "The extent of innovation we have witnessed over the years has been greatly aided by the low cost of entry. Any form of regulation or licensing will increase the entry cost, thereby hindering innovation and equal opportunity to startups to establish themselves in the market. Behind every Zoho, WhatsApp and Skype there are numerous failures. Licensing will essentially increase the cost and likelihood of failure - and greatly discourage innovation.\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "Question 3: Is the growth of Internet/OTT impacting the traditional revenue stream of Telecom operators/Telecom operators? If so, is the increase in data revenues of the Telecom Operators sufficient to compensate for this impact? Please comment with reasons.\n" +
                        "\n" +
                        "There is no evidence of data revenues cannibalizing revenues from voice or SMS. In fact, data usage is soaring and it is driving the demand for telecom networks.\n" +
                        "\n" +
                        "The question fails to acknowledge that revenue from data services also fall under the traditional revenue streams category as per the Unified Access License Agreement\n" +
                        "\n" +
                        "[http://www.dot.gov.in/access-services/introduction-unified-access-servicescellular-mobile-services]. So, to assume that data services are impacting the growth of “traditional revenue streams” is wrong.\n" +
                        "\n" +
                        "Services such as Skype and WhatsApp have specific use cases. They are not, and should not be, considered as substitutes to voice calling or SMS. For instance, calls made using VoIP don’t have the same clarity that we have on voice calls. Moreover, services such as WhatsApp are used for real-time chatting as opposed to SMS. Voice and SMS have their own benefits and use cases, so do VoIP and internet messaging. Customers should be free to pick and choose among these.\n" +
                        "\n" +
                        "There is still no concrete evidence suggesting that the decline in the revenues from messaging and voice calling is due to the growth of revenues from data services, and statements from experts and industry experts appear to in fact point to there being no cannibalization of revenues.\n" +
                        "\n" +
                        "Gopal Vittal, CEO, Airtel\n" +
                        "\n" +
                        "“There is still no evidence that suggests that there is cannibalization,” he said when asked about whether data is cannibalizing Airtel’s voice business. On internet messaging cannibalizing SMS revenues, he said: “At this point in time is very, very tiny. And so it is not really material as we look at it.”\n" +
                        "\n" +
                        "[http://www.medianama.com/2015/02/223-no-evidence-of-voip-cannibalization-of-voice-airtel-india-ceo-gopal-vittal/]\n" +
                        "\n" +
                        "Vittorio Colao, CEO, Vodafone\n" +
                        "\n" +
                        "“Growth in India has accelerated again (October-December), driven by data” [http://computer.financialexpress.com/columns/india-high-on-3g/9462/]\n" +
                        "\n" +
                        "The company’s India unit grew by 15%, going past its counterparts during the quarter ending December as customers used its data services. [http://articles.economictimes.indiatimes.com/2015-02-06/news/58878696_1_organic-service-revenue-vittorio-colao-vodafone-india]\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "Question 4: Should the Internet/OTT players pay for use of the Telecom Operators network over and above data charges paid by consumers? If yes, what pricing options can be adopted? Could such options include prices based on bandwidth consumption? Can prices be used as a means of product/service differentiation? Please comment with justifications.\n" +
                        "\n" +
                        "Internet-based services and apps don’t pay for telecom operators for using the network, and it should remain the same going forward. Forcing Internet-based services to pay extra for using a particular network negatively impact consumers and harm the Indian digital ecosystem. As mentioned in the above answer, data revenues of Indian telecom operators is already on an upswing and is slated to increase rapidly over the next few years, hence the argument for creating a new revenue source is not justified.\n" +
                        "\n" +
                        "Charging users extra for specific apps or services will overburden them, which in turn will lead to them not using the services at all. It is also akin to breaking up the Internet into pieces, which is fundamentally against what Net Neutrality stands for. Also, the Internet depends on interconnectivity and the users being able to have seamless experience - differential pricing will destroy the very basic tenets of the Internet.\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "Question 5: Do you agree that imbalances exist in the regulatory environment in the operation of Internet/OTT players? If so, what should be the framework to address these issues? How can the prevailing laws and regulations be applied to Internet/OTT players (who operate in the virtual world) and compliance enforced? What could be the impact on the economy? Please comment with justifications.\n" +
                        "\n" +
                        "Firstly, there is no regulatory imbalance in regards to Internet-based services and apps. It is the telecom operators who own spectrum, which is a public resource, and hence need to be licensed. Internet services don’t need licenses. Telecom operators provided the pipe or network on top of which Internet services exist. So, there’s a clear distinction between the two.\n" +
                        "\n" +
                        "It also needs to be pointed out that Internet services are already covered by the Information Technology Act, 2008 and the Indian Penal Code. So, there’s no need for a separate regulatory framework or licensing. In fact, this was the exact argument telecom operators had earlier made while stating their case for not regulating mobile value added services (MVAS), which in essence is quite similar Internet-based services.\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "Question 6: How should the security concerns be addressed with regard to OTT players providing communication services? What security conditions such as maintaining data records, logs etc. need to be mandated for such OTT players? And, how can compliance with these conditions be ensured if the applications of such OTT players reside outside the country? Please comment with justifications.\n" +
                        "\n" +
                        "The internet services and apps are well-covered under the existing laws and regulations. These include the Code of Criminal Procedure, Indian Telegraph Act, Indian Telegraph Rules, and the Information Technology Act and its different rules pertaining to intermediaries and interception. These different regulations allow the Indian government and law enforcement agencies to access the data stored by internet platforms when deemed legally necessary. Any additional regulations carry grave risk of breaching user privacy and would also require constitutional review - especially since the Government is still working on a proposed Privacy Bill.\n" +
                        "\n" +
                        "The government and courts also have the power to block access to websites on the grounds of national security and public order. It has taken similar steps in the past and has been widely reported by the media. The transparency reports periodically published by major internet companies suggests Indian government routinely requests for user data and blocking of user accounts. Between July 2014 and December 2014, Indian authorities had 5,473 requests for data, covering 7,281 user accounts from Facebook and the company had a compliance rate of 44.69%. Google had a compliance rate of 61% with respect to the requests made by different government agencies across India.\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "Question 7: How should the OTT players offering app services ensure security, safety and privacy of the consumer? How should they ensure protection of consumer interest? Please comment with justifications.\n" +
                        "\n" +
                        "Although user privacy and security is of paramount importance, additional regulation carries the inherent risk of breaching user privacy which is not in the consumer’s interest. The Information Technology Act, 2000 already addresses the security concerns of the user. But more importantly, any criminal act committed using these platforms can be tried under the Indian Penal Code. So, there is no need to burden the internet platforms with additional regulations.\n" +
                        "\n" +
                        "Also, it is worth noting that many telecom companies in India have not made information publicly available as to whether and how they comply with regulations that guarantee security, privacy and safety of the customer. TRAI’s current paper fails to articulate why the internet services and apps should be brought under similar regulations.\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "Question 8:\n" +
                        "\n" +
                        "In what manner can the proposals for a regulatory framework for OTTs in India draw from those of ETNO, referred to in para 4.23 or the best practices summarised in para 4.29? And, what practices should be proscribed by regulatory fiat? Please comment with justifications.\n" +
                        "\n" +
                        "ETNO is similar to India’s COAI which makes it an industry lobby group. Understandably, the suggestions made by ETNO heavily favor the telecom companies and will be detrimental to customers if India refers to their suggestions.\n" +
                        "\n" +
                        "ETNO’s stand have been widely criticized in the past. Europe’s own group of government regulators [Body of European Regulators for Electronic Communication (BEREC)]\n" +
                        "\n" +
                        "http://berec.europa.eu/files/document_register_store/2012/11/BoR_%2812%29_120_BEREC_on_ITR.pdf ETNO’s proposals could jeopardize the “continued development of the open, dynamic and global platform that the Internet provides” which will “lead to an overall loss of welfare”. Additionally, the international free expression group Article 19 says ETNO’s proposal “would seriously undermine net neutrality.\n" +
                        "\n" +
                        "According to Access Now, ETNO’s recommendations would have meant higher data charges for customers while from an entrepreneur’s standpoint, it will limit their ability to reach out to a wider market. For a small but fast growing startup and digital media sector in India, this can potentially ring the death knell. ETNO’s suggestions on this subject so far have failed to have been accepted by any government agency - including the regulators in their own host countries. It is therefore especially troubling that TRAI is choosing to make one of their proposals a pillar of this public consultation here in India.\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "Question 9: What are your views on net-neutrality in the Indian context? How should the various principles discussed in para 5.47 be dealt with? Please comment with justifications.\n" +
                        "\n" +
                        "Net Neutrality, by definition, means no discrimination of traffic flowing on the internet with respect to speed, access and price. Chile and Brazil, which are developing countries just like India, have passed laws supporting net neutrality. This is in addition to government commitments to implement net neutrality legislation in the United States and European Union.\n" +
                        "\n" +
                        "India has 1 billion people without internet access and it is imperative for our democracy to have an open and free internet where users are free to choose the services they want to access—instead of a telecom operator deciding what information they can access.\n" +
                        "\n" +
                        "Internet apps and services are expected to contribute 5% to India’s GDP by 2020. That will only happen of entrepreneurs, big and small, have a level playing field that encourages innovation and non-preferential treatment—something that net neutrality ensures.\n" +
                        "\n" +
                        "Assuming there is no net neutrality, only the big players will be able to strike deals with telcos while the smaller players remain inaccessible, which will go against the principles of net neutrality as listed below:\n" +
                        "\n" +
                        "No blocking by TSPs and ISPs on specific forms of internet traffic, services and applications.\n" +
                        "\n" +
                        "No slowing or “throttling” internet speeds by TSPs and ISPs on specific forms of internet traffic, services and applications.\n" +
                        "\n" +
                        "No preferential treatment of services and platforms by TSPs and ISPs.\n" +
                        "\n" +
                        "It is also worth noting that the proposed framework will give too much power in the hands of the telecom companies, which is not healthy for the ecosystem.\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "Question 10: What forms of discrimination or traffic management practices are reasonable and consistent with a pragmatic approach? What should or can be permitted? Please comment with justifications.\n" +
                        "\n" +
                        "This question assumes that traffic discrimination is necessary and is a norm. Rather, traffic discrimination should be an exception as it is against the principles of net neutrality.\n" +
                        "\n" +
                        "In such exceptional cases, telecom companies need to have the permission of TRAI or other competent government agency through public hearing to carry out “traffic management” to ensure transparency in the entire process. Further, it should be kept in mind that such steps shouldn’t interfere with the access, affordability and quality of the services.\n" +
                        "\n" +
                        "More importantly, https://ec.europa.eu/digital-agenda/sites/digital-agenda/files/Traffic%20Management%20Investigation%20BEREC_2.pdf jointly by BEREC and the European Commission suggest that the propensity of the telecom operators to restrict access of internet services is high. The report noted that telecom operators were most inclined to block and throttle P2P services on mobile as well as fixed line networks. VoIP, on the other hand, was blocked mostly on telecom networks.\n" +
                        "\n" +
                        "Keeping this in mind, TRAI needs to ensure that instances of discrimination of traffic should be few, far between and, above all, transparent.\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "Question 11: Should the TSPs be mandated to publish various traffic management techniques used for different OTT applications? Is this a sufficient condition to ensure transparency and a fair regulatory regime?\n" +
                        "\n" +
                        "The question is based on the premise that publishing various traffic management techniques for Internet services will ensure a fair regulatory regime and therefore such discrimination is permissible. As I have repeatedly said in the above answers, discrimination of services will not bring about a fair regime for users.\n" +
                        "\n" +
                        "Further, a recent study [http://bit.ly/1D7QEp9] in the UK has pointed out that merely publishing data on traffic management will not translate into a fair regime. The study found that most consumers did not understand traffic management or use it as a basis for switching operators. Those who did do so comprised a group perceived to be small or insignificant enough that most network operators did not seek to factor them into their product decisions, despite some consumers’ complaints about traffic management. In India where awareness and activism on issues of net neutrality is considerably less, it is unlikely to play the critical role that the Consultation Paper suggests.\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "Question 12: How should a conducive and balanced environment be created such that TSPs are able to invest in network infrastructure and CAPs are able to innovate and grow? Who should bear the network upgradation costs? Please comment with justifications\n" +
                        "\n" +
                        "The question assumes that a “balanced” environment would lead to increased investment and upgradation of networks.. However, if revenue is generated by charging CAPs to reach customers rather than only charging users for data, the incentives for a TSP can potentially change. Telecom operators now gain the incentive to maintain a level scarcity and not upgrade existing infrastructure in order to maximize gatekeeper revenue. There is no evidence to support that access fees charged to CAPs will spark network upgradation and may have the opposite effect itself.\n" +
                        "\n" +
                        "We’ve mentioned before that telecom operators should be acting as data pipes which can provide users access to Internet and that they stand to substantially gain from upgrading networks. Telecom operators stand to gain substantially by upgrading existing networks by proliferating the use of data by users, and it therefore stands to reason that the costs of upgradation should be borne by them. The above answers also point out that the heads of the leading telecom operators in the country have not seen evidence of cannibalization of existing services and that data usage has only been steadily increasing.\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "Question 13: Should TSPs be allowed to implement non-price based discrimination of services? If so, under what circumstances are such practices acceptable? What restrictions, if any, need to be placed so that such measures are not abused? What measures should be adopted to ensure transparency to consumers? Please comment with justifications.\n" +
                        "\n" +
                        "Discrimination of services in any form is detrimental for the growth of the telecom industry itself and there should be no circumstance for a telecom operator to do so. Given the diverse nature of the Internet, telecom operators should not be allowed to determine what type of service should get more priority. For example, a consumer in India probably relies on VoIP calls to keep in touch with people abroad and if there is throttling of these services, it infringes on the user’s fundamental right of freedom of expression. An Internet service that a telecom operator thinks which could lead to traffic congestion, might be vital to consumers. Further, a telecom operator might use throttling to further a service promoted by them and induce consumers into using them, thereby eliminating choice.\n" +
                        "\n" +
                        "Transparency alone will not bring about a fair regime for users, and it is crucial that TSPs be prohibited from discriminating between services\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "Question 14: Is there a justification for allowing differential pricing for data access and OTT communication services? If so, what changes need to be brought about in the present tariff and regulatory framework for telecommunication services in the country? Please comment with justifications.\n" +
                        "\n" +
                        "The question above is simply a rephrasing Question 13. Differential pricing for data access and OTT communication services again simply amounts to discrimination of data services. Hence there is no justification for differential pricing other than furthering corporate profit. Telecom operators stand to gain substantially from the proliferation of all data services including communication services. A neutral internet allows smaller companies to innovate and compete with larger players and ensure that there is a free market. Any changes in the present tariff and regulatory framework is not needed save for ensuring that the interests of the consumer is taken care of.\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "Question 15: Should OTT communication service players be treated as Bulk User of Telecom Services (BuTS)? How should the framework be structured to prevent any discrimination and protect stakeholder interest? Please comment with justification.\n" +
                        "\n" +
                        "Treating OTT communication service players as Bulk User of Telecom Services again amounts to discrimination of data services and hence it should not be allowed. The question also further assumes that the stakeholders are only the telecom operators and not the consumers. If only the interests of the telecom operators are protected by treating services which compete with their traditional services differently rather than innovating themselves, it would lead to a situation of anti-competitiveness. Telecom companies have an interest in imposing their control over information and communication networks, but the price of that would mean stifling competition, increased barriers for innovation and business and eventually infringe on the fundamental rights of Indian citizens.\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "Question 16: What framework should be adopted to encourage India-specific OTT apps? Please comment with justifications.\n" +
                        "\n" +
                        "Only two steps need to be taken to foster the growth and innovation of India specific apps and services. First, there should be no additional regulation or licensing and strong net neutrality laws should be enacted.\n" +
                        "\n" +
                        "These steps will ensure that India continues to have a diverse app economy where entry barriers are minimal and entrepreneurs can launch their product without having to worry about discriminatory treatment from the telecom operators. In such a case, the best product will win which will be beneficial for the customers and the telecom as well as the Internet industry.\n" +
                        "\n" +
                        "The agnostic nature of internet networks has boosted the growth of India’s app economy but we risk destroying this fast growing sector by violating net neutrality.\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "Question 17: If the OTT communication service players are to be licensed, should they be categorised as ASP or CSP? If so, what should be the framework? Please comment with justifications.\n" +
                        "\n" +
                        "The question of categorising doesn’t even arise, because as mentioned earlier any extra regulations or licensing is going to be detrimental to the end user. Requiring licensing of online services and mobile apps under the current telecom framework in India will have enormous negative consequences. The impossibly onerous burdens imposed by such licensing would results in many such globally developed services and apps not being launched in India - and our own startup efforts to develop local versions of such apps being killed in their early stages. The net results would be decreased consumer benefit and a massive slowdown in innovation and reduced “Make in India” efforts due to the regulatory cost of doing business becoming very high.\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "Question 18: Is there a need to regulate subscription charges for OTT communication services? Please comment with justifications.\n" +
                        "\n" +
                        "Subscription charges for such apps need to be allowed to evolve as it would in a pure market economy. The subscribers (buyers) would want to pay the lowest possible price, and the app developers/companies (sellers) would want to charge as much as possible, eventually leading to a fair price.\n" +
                        "\n" +
                        "Subscription charges for such Internet-based services have remained, more or less, quite low in India, especially because the cost of switching from one service provider to another is also quite low: This competition will ensure that charges remain fair, without the need to regulate them, going forward as well. As noted in response to earlier questions, existing Indian law also applies to online services - which would include the Consumer Protection Act and other regulations meant to prevent cheating or other illegal pricing issues.\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "Question 19: What steps should be taken by the Government for regulation of non-communication OTT players? Please comment with justifications.\n" +
                        "\n" +
                        "As mentioned earlier, irrespective of what an OTT app is used for (communication, online shopping, etc) they’re all essentially Internet-based services, and hence there is no question of creating new regulatory measures.\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "Question 20: Are there any other issues that have a bearing on the subject discussed?\n" +
                        "\n" +
                        "In the interim, TRAI should issue an order or regulation preventing network neutrality violations by telecom service providers. Some telecom companies have shown scant respect for the issues presently under consideration and despite its questionable legality have rolled out various services which violate network neutrality. Any delay in forming regulations or preventing them in the interim till the process is complete is only likely to consolidate their status. This is not only an affront to the Internet users in India but also to the regulatory powers of the TRAI.\n" +
                        "\n" +
                        "If the question of regulating subscription charges arises because of the fear of OTT communication services/VoIP cannibalising Voice services by telcos, then it needs to be pointed out that more than one telecom operator in India has already come out and said that there’s no evidence to support such a fear.\n" +
                        "\n" +
                        "Earlier this year, Airtel India CEO Gopal Vittal had clearly said during the company’s earnings conference call that there’s no evidence of VoIP cannibalisation of voice services (http://bit.ly/1DzZQ77 - pdf). Last year, Idea Cellular MD Himanshu Kapania had also said that OTT apps like Viber have had some impact on their International calling business, but on regular voice calls, there was no impact (http://www.medianama.com/2014/07/223-idea-cellular-viber/).\n" +
                        "\n");


                List activities = packageManager.queryIntentActivities(emailIntent,
                        PackageManager.MATCH_DEFAULT_ONLY);
                boolean isIntentSafe = activities.size() > 0;
                if(isIntentSafe){
                    startActivity(emailIntent);
                }else{
                    Toast.makeText(getActivity().getApplicationContext(),"Email client Required: You don't have a EMail client installed", Toast.LENGTH_SHORT).show();
                }
            }
        });
          visitWebsite1.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  goToUrl("http://www.savetheinternet.in/");
              }
          });
           visitWebsite2.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   goToUrl("http://www.netneutrality.in/");
               }
           });
        return v;

    }

    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}
