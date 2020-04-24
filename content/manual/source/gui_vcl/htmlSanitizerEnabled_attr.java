protected static final String UNSAFE_HTML = "<i>Jackdaws </i><u>love</u> <font size=\"javascript:alert(1)\" " +
            "color=\"moccasin\">my</font> " +
            "<font size=\"7\">big</font> <sup>sphinx</sup> " +
            "<font face=\"Verdana\">of</font> <span style=\"background-color: " +
            "red;\">quartz</span><svg/onload=alert(\"XSS\")>";

@Inject
private TextField<String> textFieldOn;
@Inject
private TextField<String> textFieldOff;

@Subscribe
public void onInit(InitEvent event) {
    textFieldOn.setCaption(UNSAFE_HTML);
    textFieldOn.setCaptionAsHtml(true);
    textFieldOn.setHtmlSanitizerEnabled(true); // <1>

    textFieldOff.setCaption(UNSAFE_HTML);
    textFieldOff.setCaptionAsHtml(true);
    textFieldOff.setHtmlSanitizerEnabled(false); // <2>
}