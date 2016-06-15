function putForm(a) {
    for (k in a) a[k] = $("*[name='" + k + "']").val()
}
function putIdForm(a) {
    for (k in a) a[k] = $("#" + k).val()
}
function validateForm(a) {
    return initValidate(),
    $(a).form("validate")
}
function initValidate(a) {
    void 0 == a && (a = !1),
    $(".validatebox-text").each(function() {
        $(this).attr("autocomplete") || $(this).css("height", "30px")
    }),
    a ? $(".validatebox-text").bind("blur",
    function() {
        $(this).validatebox("enableValidation").validatebox("validate")
    }) : $(".validatebox-text").validatebox("enableValidation").validatebox("validate")
}
function getRequestParameter(a, b) {
    var c, d, e, f;
    if ((void 0 == b || null == b) && (b = window.location.search), -1 != b.indexOf("?")) for (c = b.substr(1), strs = c.split("&"), d = "", e = "", f = 0; f < strs.length; f++) e = strs[f].split("=")[0],
    void 0 != e && (d = strs[f].split("=")[1], void 0 == d && (d = ""), a[e] = d)
}
function getFields(a, b) {
    var e, f, c = $(a + " thead tr th"),
    d = [];
    for (e = 0; e < c.length; e++) f = $(c[e]).attr("field"),
    "ck" != f && "ROWID" != f && (2 == b && (f = $(c[e]).html()), d.push(f));
    return d
}
function msgbox(a) {
    $.messager.show({
        title: "提示",
        height: 150,
        width: 300,
        msg: a,
        timeout: 5e3,
        showType: "slide"
    })
}
function getSelectRow(a, b) {
    void 0 == b && (b = !1);
    var c = $(a).datagrid("getSelections");
    return 0 == c.length || !b && c.length > 1 ? (msgbox("请确保选择了一条记录。"), null) : b ? c: c[0]
}
function initPage(a, b, c) {
    $(a).datagrid("getPager").pagination({
        showPageList: !1,
        pageSize: b,
        onSelectPage: function(a) {
            c(a, pageMap)
        }
    })
}
function getContextPath() {
    var c, a = "commons/engine.js",
    b = document.getElementsByTagName("script");
    for (i = 0; i < b.length; i++) if (b[i].src.match(a)) return c = b[i].src.replace(a, ""),
    -1 != c.indexOf("?") && (c = c.substring(0, c.indexOf("?"))),
    c;
    return "/"
}
function loadPageData(a, b, c, d, e, f) {
    loadPageData2(a["queryForPage"], b, c, d, e, f)
}
function setFooter(a) {
    null != a["footer"] && (footer_data = a["footer"]),
    a["footer"] = footer_data
}
function loadPageData2(a, b, c, d, e, f, g) {
    pageMap = e;
    var h = (c - 1) * parseInt(d);
    a(h, d, e,
    function(a) {
        if (void 0 != g && null != g && g(a), 1 == c ? (pageCount = a["total"], pageMap["_pageCount_"] = pageCount) : pageCount = pageMap["_pageCount_"], a["total"] = pageCount, a["rows"].length > 0) for (var e = 0; d > e && void 0 != a["rows"][e]; e++) a["rows"][e]["ROWID"] = ++h;
        $(b).datagrid("getPager").pagination({
            pageNumber: c
        }),
        $(b).datagrid("loadData", a),
        void 0 != f && null != f && f(a)
    })
}
function MsgSupport() {}
function setCookie(a, b) {
    var c = 30,
    d = new Date;
    d.setTime(d.getTime() + 1e3 * 60 * 60 * 24 * c),
    document.cookie = a + "=" + escape(b) + ";expires=" + d.toGMTString()
}
function getCookie(a) {
    var b, c = new RegExp("(^| )" + a + "=([^;]*)(;|$)");
    return (b = document.cookie.match(c)) ? unescape(b[2]) : null
}
function delCookie(a) {
    var c, b = new Date;
    b.setTime(b.getTime() - 1),
    c = getCookie(a),
    null != c && (document.cookie = a + "=" + c + ";expires=" + b.toGMTString())
}
"undefined" == typeof dwr && (dwr = {}),
function() {
    function ignoreIfUnloading(a, b) {
        dwr.engine._unloading || (a && 0 == a.async ? b() : setTimeout(function() {
            dwr.engine._unloading || b()
        },
        100))
    }
    var userAgent, versionString, version, geckoPos, g;
    dwr.engine || (dwr.engine = {}),
    dwr.engine.setErrorHandler = function(a) {
        dwr.engine._errorHandler = a
    },
    dwr.engine.setWarningHandler = function(a) {
        dwr.engine._warningHandler = a
    },
    dwr.engine.setTextHtmlHandler = function(a) {
        dwr.engine._textHtmlHandler = a
    },
    dwr.engine.setPollStatusHandler = function(a) {
        dwr.engine._pollStatusHandler = a
    },
    dwr.engine.setTimeout = function(a) {
        dwr.engine._timeout = a
    },
    dwr.engine.setPreHook = function(a) {
        dwr.engine._preHook = a
    },
    dwr.engine.setPostHook = function(a) {
        dwr.engine._postHook = a
    },
    dwr.engine.setHeaders = function(a) {
        dwr.engine._headers = a
    },
    dwr.engine.setAttributes = function(a) {
        dwr.engine._attributes = a
    },
    dwr.engine.setOrdered = function(a) {
        dwr.engine._ordered = a
    },
    dwr.engine.setAsync = function(a) {
        dwr.engine._async = a
    },
    dwr.engine.setActiveReverseAjax = function(a) {
        if (a) {
            if (dwr.engine._activeReverseAjax) return;
            dwr.engine._retryIntervals = dwr.engine._defaultRetryIntervals,
            dwr.engine._activeReverseAjax = !0,
            dwr.engine._poll()
        } else dwr.engine._activeReverseAjax && dwr.engine._pollBatch && dwr.engine.transport.abort(dwr.engine._pollBatch),
        dwr.engine._activeReverseAjax = !1
    },
    dwr.engine.setNotifyServerOnPageUnload = function(a, b) {
        dwr.engine._asyncUnload = void 0 !== b ? b: !1,
        dwr.engine._isNotifyServerOnPageUnload = a
    },
    dwr.engine.setMaxRetries = function(a) {
        dwr.engine._maxRetries = a
    },
    dwr.engine.setRetryIntervals = function(a) {
        dwr.engine._retryIntervals = a
    },
    dwr.engine.defaultErrorHandler = function(a, b) {
        dwr.engine._debug("Error: " + b.name + ", " + b.message, !0),
        null == a || "" == a ? alert("服务端运行出现错误。") : -1 != a.indexOf("0x80040111") ? dwr.engine._debug(a) : alert(a)
    },
    dwr.engine.defaultWarningHandler = function(a) {
        dwr.engine._debug(a)
    },
    dwr.engine.defaultPollStatusHandler = function(a) {
        dwr.engine._debug("pollStatusHandler - online: " + a)
    },
    dwr.engine.beginBatch = function() {
        return dwr.engine._batch ? (dwr.engine._handleError(null, {
            name: "dwr.engine.batchBegun",
            message: "Batch already begun"
        }), void 0) : (dwr.engine._batch = dwr.engine.batch.create(), void 0)
    },
    dwr.engine.endBatch = function(a) {
        var b = dwr.engine._batch;
        return null == b ? (dwr.engine._handleError(null, {
            name: "dwr.engine.batchNotBegun",
            message: "No batch in progress"
        }), void 0) : (dwr.engine._batch = null, 0 != b.map.callCount ? (a && dwr.engine.batch.merge(b, a), b.async && (dwr.engine._ordered || dwr.engine._internalOrdered) && 0 != dwr.engine._batchesLength ? (dwr.engine._batchQueue[dwr.engine._batchQueue.length] = b, void 0) : dwr.engine.transport.send(b)) : void 0)
    },
    dwr.engine.openInDownload = function(a) {
        var b = document.createElement("div");
        document.body.appendChild(b),
        b.innerHTML = "<iframe width='0' height='0' scrolling='no' frameborder='0' src='" + a + "'></iframe>"
    },
    dwr.version = {
        major: parseInt("3"),
        minor: parseInt("0"),
        revision: parseInt("0"),
        build: parseInt("312"),
        title: "RC2-final",
        label: "3.0.0-RC2-final-312"
    },
    dwr.engine._allowGetForSafariButMakeForgeryEasier = "false",
    dwr.engine._scriptTagProtection = "throw 'allowScriptTagRemoting is false.';",
    dwr.engine._pathToDwrServlet = "undefined" != typeof pathToDwrServlet ? pathToDwrServlet: "/platform/dwr",
    dwr.engine._contextPath = "/platform",
    dwr.engine._pollWithXhr = "false",
    dwr.engine._pollOnline = !0,
    dwr.engine._ModePlainCall = "/call/plaincall/",
    dwr.engine._ModePlainPoll = "/call/plainpoll/",
    dwr.engine._ModeHtmlCall = "/call/htmlcall/",
    dwr.engine._ModeHtmlPoll = "/call/htmlpoll/",
    dwr.engine._async = Boolean("true"),
    dwr.engine._pageId = null,
    dwr.engine._dwrSessionId = null,
    dwr.engine._scriptSessionId = "",
    dwr.engine._preHook = null,
    dwr.engine._postHook = null,
    dwr.engine._batches = {},
    dwr.engine._batchesLength = 0,
    dwr.engine._batchQueue = [],
    dwr.engine._ordered = !1,
    dwr.engine._internalOrdered = !1,
    dwr.engine._batch = null,
    dwr.engine._timeout = 0,
    dwr.engine._activeReverseAjax = !1,
    dwr.engine._pollBatch = null,
    dwr.engine._pollCometInterval = 200,
    dwr.engine.SSL_SECURE_URL = "about:blank",
    dwr.engine._retries = 0,
    dwr.engine._maxRetries = -1,
    dwr.engine._retryIntervals = [],
    dwr.engine._defaultRetryIntervals = [1, 1, 10],
    dwr.engine._textHtmlHandler = null,
    dwr.engine._headers = null,
    dwr.engine._attributes = null,
    dwr.engine._nextBatchId = 0,
    dwr.engine._instanceId = -1,
    dwr.engine._propnames = ["async", "timeout", "errorHandler", "warningHandler", "textHtmlHandler"],
    dwr.engine._partialResponseNo = 0,
    dwr.engine._partialResponseYes = 1,
    dwr.engine._partialResponseFlush = 2,
    dwr.engine._isNotifyServerOnPageUnload = !1,
    dwr.engine._asyncUnload = !1,
    dwr.engine._mappedClasses = {},
    dwr.engine._errorHandler = dwr.engine.defaultErrorHandler,
    dwr.engine._warningHandler = dwr.engine.defaultWarningHandler,
    dwr.engine._pollStatusHandler = dwr.engine.defaultPollStatusHandler,
    dwr.engine._postSeperator = "\n",
    dwr.engine._defaultInterceptor = function(a) {
        return a
    },
    dwr.engine._urlRewriteHandler = dwr.engine._defaultInterceptor,
    dwr.engine._contentRewriteHandler = dwr.engine._defaultInterceptor,
    dwr.engine._replyRewriteHandler = dwr.engine._defaultInterceptor,
    dwr.engine._excludeObjectAttributes = {
        $dwrClassName: !0,
        $dwrByRef: !0,
        $_dwrConversionRef: !0
    },
    dwr.engine._unloading = !1,
    dwr.engine._unloader = function() {
        var a, b;
        dwr.engine._unloading = !0,
        dwr.engine._batchQueue.length = 0;
        for (b in dwr.engine._batches) a = dwr.engine._batches[b],
        a && a.map && a.req && a.req.abort();
        dwr.engine._isNotifyServerOnPageUnload && (dwr.engine._debug("calling unloader for: " + dwr.engine._scriptSessionId), a = {
            map: {
                callCount: 1,
                "c0-scriptName": "__System",
                "c0-methodName": "pageUnloaded",
                "c0-id": 0
            },
            paramCount: 0,
            isPoll: !1,
            async: dwr.engine._asyncUnload,
            headers: {},
            preHooks: [],
            postHooks: [],
            timeout: dwr.engine._timeout,
            errorHandler: null,
            warningHandler: null,
            textHtmlHandler: null,
            path: dwr.engine._pathToDwrServlet,
            handlers: [{
                exceptionHandler: null,
                callback: null
            }]
        },
        dwr.engine.transport.send(a), dwr.engine._isNotifyServerOnPageUnload = !1)
    },
    dwr.engine._execute = function(a, b, c, d) {
        var e, f = !1;
        if (null == dwr.engine._batch && (dwr.engine.beginBatch(), f = !0), e = dwr.engine._batch, null == e.path) e.path = a;
        else if (e.path != a) return dwr.engine._handleError(e, {
            name: "dwr.engine.multipleServlets",
            message: "Can't batch requests to multiple DWR Servlets."
        }),
        void 0;
        return dwr.engine.batch.addCall(e, b, c, d),
        e.map.callCount++,
        f ? dwr.engine.endBatch() : void 0
    },
    dwr.engine._poll = function() {
        dwr.engine._activeReverseAjax && (dwr.engine._pollBatch = dwr.engine.batch.createPoll(), dwr.engine.transport.send(dwr.engine._pollBatch))
    },
    dwr.engine._eval = function(script) {
        return null == script ? null: "" == script ? (dwr.engine._debug("Warning: blank script", !0), null) : eval(script)
    },
    dwr.engine._callPostHooks = function(a) {
        if (a.postHooks) {
            for (var b = 0; b < a.postHooks.length; b++) a.postHooks[b]();
            a.postHooks = null
        }
    },
    dwr.engine._handleError = function(a, b) {
        var c, d, e = [];
        if (dwr.engine._retries <= 1) {
            if (a) for (c = 0; c < a.map.callCount; c++) d = a.handlers[c],
            d.completed || ("function" == typeof d.errorHandler && e.push(d.errorHandler), d.completed = !0);
            a && dwr.engine.batch.remove(a)
        }
        ignoreIfUnloading(a,
        function() {
            if (dwr.engine._retries <= 1) {
                dwr.engine._prepareException(b);
                for (var c; e.length > 0;) c = e.shift(),
                c(b.message, b);
                a && "function" == typeof a.errorHandler ? a.errorHandler(b.message, b) : dwr.engine._errorHandler && dwr.engine._errorHandler(b.message, b)
            }
        })
    },
    dwr.engine._handlePollRetry = function(a, b) {
        var c;
        a && a.isPoll && (c = dwr.engine._retries < dwr.engine._retryIntervals.length ? 1e3 * dwr.engine._retryIntervals[dwr.engine._retries] : 1e3 * dwr.engine._retryIntervals[dwr.engine._retryIntervals.length - 1], -1 == dwr.engine._maxRetries || dwr.engine._retries <= dwr.engine._maxRetries ? (dwr.engine._retries == dwr.engine._retryIntervals.length - 1 && (dwr.engine._debug("poll retry - going offline: " + c / 1e3 + " seconds"), dwr.engine._handlePollStatusChange(!1, b)), dwr.engine._retries++, dwr.engine.batch.remove(a), dwr.engine._debug("poll retry - interval: " + c / 1e3 + " seconds"), setTimeout(dwr.engine._poll, c)) : dwr.engine._debug("max retries reached, stop polling for server status."))
    },
    dwr.engine._handlePollStatusChange = function(a, b) {
        a || (dwr.engine._pollOnline = !1),
        dwr.engine._pollStatusHandler(a, b),
        a && (dwr.engine._pollOnline = !0, dwr.engine._retries = 0)
    },
    dwr.engine._handleWarning = function(a, b) {
        ignoreIfUnloading(a,
        function() {
            dwr.engine._prepareException(b),
            a && "function" == typeof a.warningHandler ? a.warningHandler(b.message, b) : dwr.engine._warningHandler && dwr.engine._warningHandler(b.message, b),
            a && dwr.engine.batch.remove(a)
        })
    },
    dwr.engine._prepareException = function(a) {
        "string" == typeof a && (a = {
            name: "unknown",
            message: a
        }),
        null == a.message && (a.message = ""),
        null == a.name && (a.name = "unknown")
    },
    dwr.engine._delegate = function() {
        function a() {}
        return function(b) {
            return a.prototype = b,
            new a
        }
    } (),
    dwr.engine._createFromMap = function(a) {
        var b = new this;
        for (prop in a) a.hasOwnProperty(prop) && (b[prop] = a[prop]);
        return b
    },
    dwr.engine._global = function() {
        return this
    }.call(null),
    dwr.engine._getObject = function(a) {
        for (var b, c, d = a.split("."), e = dwr.engine._global; d.length > 0;) {
            if (c = d.shift(), b = e[c], d.length > 0 && null == b) return void 0;
            e = b
        }
        return b
    },
    dwr.engine._setObject = function(a, b) {
        for (var c, d, e = a.split("."), f = dwr.engine._global; e.length > 0;) d = e.shift(),
        0 == e.length ? f[d] = b: (c = f[d], null == c && (f[d] = c = {}), f = c)
    },
    dwr.engine._debug = function(a, b) {
        var c, d, e = !1;
        try {
            window.console ? (b && window.console.trace && window.console.trace(), window.console.log(a), e = !0) : window.opera && window.opera.postError ? (window.opera.postError(a), e = !0) : window.Jaxer && Jaxer.isOnServer && (Jaxer.Log.info(a), e = !0)
        } catch(f) {}
        e || (c = document.getElementById("dwr-debug"), c && (d = a + "<br/>" + c.innerHTML, d.length > 2048 && (d = d.substring(0, 2048)), c.innerHTML = d))
    },
    dwr.engine.remote = {
        handleCallback: function(a, b, c) {
            var d, e = dwr.engine._batches[a];
            if (null == e) return dwr.engine._debug("Warning: batch == null in remoteHandleCallback for batchId=" + a, !0),
            void 0;
            e.reply = c;
            try {
                d = e.handlers[b],
                d ? (e.handlers[b].completed = !0, "function" == typeof d.callback && d.callback.apply(d.callbackScope, [c, d.callbackArg])) : dwr.engine._debug("Warning: Missing handlers. callId=" + b, !0)
            } catch(f) {
                dwr.engine._handleError(e, f)
            }
        },
        handleFunctionCall: function(a, b) {
            var c = dwr.engine.serialize.remoteFunctions[a];
            c.apply(window, b)
        },
        handleObjectCall: function(a, b, c) {
            var d = dwr.engine.serialize.remoteFunctions[a];
            d[b].apply(d, c)
        },
        handleSetCall: function(a, b, c) {
            var d = dwr.engine.serialize.remoteFunctions[a];
            d[b] = c
        },
        handleFunctionClose: function(a) {
            delete dwr.engine.serialize.remoteFunctions[a]
        },
        handleException: function(a, b, c) {
            var d, e = dwr.engine._batches[a];
            return null == e ? (dwr.engine._debug("Warning: null batch in remoteHandleException", !0), void 0) : (d = e.handlers[b], e.handlers[b].completed = !0, null == d ? (dwr.engine._debug("Warning: null handlers in remoteHandleException", !0), void 0) : (void 0 == c.message && (c.message = ""), "function" == typeof d.exceptionHandler ? d.exceptionHandler.call(d.exceptionScope, c.message, c, d.exceptionArg) : "function" == typeof e.errorHandler && e.errorHandler(c.message, c), void 0))
        },
        handleBatchException: function(a, b) {
            var c = null == dwr.engine._receivedBatch && null != b;
            c && (dwr.engine._receivedBatch = dwr.engine._batches[b]),
            void 0 == a.message && (a.message = ""),
            dwr.engine._handleError(dwr.engine._receivedBatch, a),
            c && (dwr.engine._receivedBatch = null, dwr.engine.batch.remove(dwr.engine._batches[b]))
        },
        handleNewWindowName: function(a) {
            dwr.engine._debug("Setting new window name: " + a),
            null != window.name && "" != window.name && dwr.engine._debug("- Warning: This will override existing name of: " + window.name),
            window.name = a
        },
        handleForeign: function(a, b) {
            var c = window.open(null, a);
            null != c ? null != c.dwr ? c.dwr.engine._eval(b) : dwr.engine._debug("Found window, but DWR did not exist in it") : dwr.engine._debug("Could not find window")
        },
        pollCometDisabled: function(a, b) {
            dwr.engine.setActiveReverseAjax(!1);
            var c = null == dwr.engine._receivedBatch && null != b;
            c && (dwr.engine._receivedBatch = dwr.engine._batches[b]),
            void 0 == a.message && (a.message = ""),
            dwr.engine._handleError(dwr.engine._receivedBatch, a),
            c && (dwr.engine._receivedBatch = null, dwr.engine.batch.remove(dwr.engine._batches[b]))
        },
        newObject: function(a, b) {
            var c = dwr.engine._mappedClasses[a];
            return c && c.createFromMap ? c.createFromMap(b) : (b.$dwrClassName = a, b)
        }
    },
    dwr.engine.serialize = {
        domDocument: ["Msxml2.DOMDocument.6.0", "Msxml2.DOMDocument.5.0", "Msxml2.DOMDocument.4.0", "Msxml2.DOMDocument.3.0", "MSXML2.DOMDocument", "MSXML.DOMDocument", "Microsoft.XMLDOM"],
        remoteFunctions: {},
        funcId: 0,
        toDomElement: function(a) {
            return dwr.engine.serialize.toDomDocument(a).documentElement
        },
        toDomDocument: function(a) {
            var b, c, d, e;
            if (window.DOMParser) {
                if (c = new DOMParser, b = c.parseFromString(a, "text/xml"), !b.documentElement || "parsererror" == b.documentElement.tagName) throw d = b.documentElement.firstChild.data,
                d += "\n" + b.documentElement.firstChild.nextSibling.firstChild.data;
                return b
            }
            return window.ActiveXObject ? (b = dwr.engine.util.newActiveXObject(dwr.engine.serialize.domDocument), b.loadXML(a), b) : (e = document.createElement("div"), e.innerHTML = a, e)
        },
        convert: function(a, b, c, d, e, f) {
            var g, h;
            if (null == d) return a.map[e] = "null:null",
            void 0;
            switch (typeof d) {
            case "boolean":
                a.map[e] = "boolean:" + d;
                break;
            case "number":
                a.map[e] = "number:" + d;
                break;
            case "string":
                a.map[e] = "string:" + encodeURIComponent(d);
                break;
            case "object":
                g = dwr.engine.serialize.lookup(b, c, d, e),
                h = Object.prototype.toString.call(d),
                d.$dwrByRef ? a.map[e] = dwr.engine.serialize.convertByReference(a, b, c, d, e, f + 1) : null != g ? a.map[e] = g: "[object String]" == h ? a.map[e] = "string:" + encodeURIComponent(d) : "[object Boolean]" == h ? a.map[e] = "boolean:" + d: "[object Number]" == h ? a.map[e] = "number:" + d: "[object Date]" == h ? a.map[e] = "date:" + d.getTime() : "[object Array]" == h ? a.map[e] = dwr.engine.serialize.convertArray(a, b, c, d, e, f + 1) : d && d.tagName && "input" == d.tagName.toLowerCase() && d.type && "file" == d.type.toLowerCase() ? (a.fileUpload = !0, a.map[e] = d) : a.map[e] = d.nodeName && d.nodeType ? dwr.engine.serialize.convertXml(a, b, c, d, e, f + 1) : dwr.engine.serialize.convertObject(a, b, c, d, e, f + 1);
                break;
            case "function":
                0 == f && (a.map[e] = dwr.engine.serialize.convertByReference(a, b, c, d, e, f + 1));
                break;
            default:
                dwr.engine._handleWarning(null, {
                    name: "dwr.engine.unexpectedType",
                    message: "Unexpected type: " + typeof d + ", attempting default converter."
                }),
                a.map[e] = "default:" + d
            }
        },
        convertByReference: function(a, b, c, d) {
            var e = "f" + dwr.engine.serialize.funcId;
            return dwr.engine.serialize.remoteFunctions[e] = d,
            dwr.engine.serialize.funcId++,
            "byref:" + e
        },
        convertArray: function(a, b, c, d, e, f) {
            var g, h, i, j;
            if (dwr.engine.isIE <= 7) {
                for (i = ["array:["], h = 0; h < d.length; h++) 0 != h && i.push(","),
                a.paramCount++,
                g = "c" + dwr.engine._batch.map.callCount + "-e" + a.paramCount,
                dwr.engine.serialize.convert(a, b, c, d[h], g, f + 1),
                i.push("reference:"),
                i.push(g);
                i.push("]"),
                j = i.join("")
            } else {
                for (j = "array:[", h = 0; h < d.length; h++) 0 != h && (j += ","),
                a.paramCount++,
                g = "c" + dwr.engine._batch.map.callCount + "-e" + a.paramCount,
                dwr.engine.serialize.convert(a, b, c, d[h], g, f + 1),
                j += "reference:",
                j += g;
                j += "]"
            }
            return j
        },
        convertObject: function(a, b, c, d, e, f) {
            var g, h, i = "Object_" + dwr.engine.serialize.getObjectClassName(d).replace(/:/g, "?") + ":{",
            j = d.constructor && d.constructor.$dwrClassMembers ? d.constructor.$dwrClassMembers: d;
            for (g in j)"function" == typeof d[g] || dwr.engine._excludeObjectAttributes[g] || (a.paramCount++, h = "c" + dwr.engine._batch.map.callCount + "-e" + a.paramCount, dwr.engine.serialize.convert(a, b, c, d[g], h, f + 1), i += encodeURIComponent(g) + ":reference:" + h + ", ");
            return ", " == i.substring(i.length - 2) && (i = i.substring(0, i.length - 2)),
            i += "}"
        },
        convertXml: function(a, b, c, d) {
            var e;
            return e = window.XMLSerializer ? (new XMLSerializer).serializeToString(d) : d.toXml ? d.toXml: d.innerHTML,
            "xml:" + encodeURIComponent(e)
        },
        lookup: function(a, b, c, d) {
            var e;
            if ("$_dwrConversionRef" in c && (e = c.$_dwrConversionRef, e && a[e] != c && (e = null)), null == e) for (r in b) if (b[r] == c) {
                e = r;
                break
            }
            if (null != e) return "reference:" + e;
            try {
                c.$_dwrConversionRef = d,
                a[d] = c
            } catch(f) {
                b[d] = c
            }
            return null
        },
        cleanup: function(a) {
            for (name in a) {
                var b = a[name];
                try {
                    delete b.$_dwrConversionRef
                } catch(c) {
                    b.$_dwrConversionRef = void 0
                }
            }
        },
        getObjectClassName: function(a) {
            return a.$dwrClassName ? a.$dwrClassName: a.constructor && a.constructor.$dwrClassName ? a.constructor.$dwrClassName: "Object"
        }
    },
    dwr.engine.transport = {
        send: function(a) {
            if (dwr.engine.transport.updateDwrSessionFromCookie(), dwr.engine._dwrSessionId) dwr.engine.transport.send2(a);
            else {
                dwr.engine._internalOrdered = !0;
                var b = {
                    map: {
                        callCount: 1,
                        "c0-scriptName": "__System",
                        "c0-methodName": "generateId",
                        "c0-id": 0
                    },
                    paramCount: 0,
                    isPoll: !1,
                    async: a.async,
                    headers: {},
                    preHooks: [],
                    postHooks: [function() {
                        dwr.engine._internalOrdered = !1
                    }],
                    timeout: dwr.engine._timeout,
                    errorHandler: a.errorHandler,
                    warningHandler: a.warningHandler,
                    textHtmlHandler: a.textHtmlHandler,
                    path: a.path,
                    handlers: [{
                        exceptionHandler: null,
                        callback: function(b) {
                            dwr.engine.transport.updateDwrSessionFromCookie(),
                            dwr.engine._dwrSessionId || dwr.engine.transport.setDwrSession(b),
                            dwr.engine.transport.send2(a)
                        }
                    }]
                };
                dwr.engine.transport.send2(b)
            }
        },
        send2: function(a) {
            var b, c, d;
            if (dwr.engine.batch.prepareToSend(a), b = !1, null == a.path && (a.path = dwr.engine._pathToDwrServlet), (0 == a.path.indexOf("http://") || 0 == a.path.indexOf("https://")) && (c = a.path.split("/", 3).join("/"), d = window.location.href.split("/", 3).join("/"), b = c != d), a.fileUpload) {
                if (b) throw new Error("Cross domain file uploads are not possible with this release of DWR");
                a.transport = dwr.engine.transport.iframe
            } else a.transport = b && !dwr.engine.isJaxerServer ? dwr.engine.transport.scriptTag: dwr.engine.transport.xhr;
            return a.transport.send(a)
        },
        complete: function(a) {
            dwr.engine.batch.validate(a),
            dwr.engine.transport.remove(a)
        },
        abort: function(a) {
            var b = a.transport;
            dwr.engine.transport.remove(a),
            b.abort && b.abort(a),
            dwr.engine._handleError(a, {
                name: "dwr.engine.timeout",
                message: "Timeout"
            })
        },
        remove: function(a) {
            a.transport && (dwr.engine._callPostHooks(a), a.transport.remove(a), a.transport = null),
            dwr.engine.batch.remove(a)
        },
        setDwrSession: function(a) {
            dwr.engine._dwrSessionId = a,
            document.cookie = "DWRSESSIONID=" + a + "; path=" + ("" != dwr.engine._contextPath ? dwr.engine._contextPath: "/"),
            dwr.engine._scriptSessionId = a + "/" + dwr.engine._pageId
        },
        updateDwrSessionFromCookie: function() {
            if (!dwr.engine._dwrSessionId) {
                var a = document.cookie.match(/(?:^|; )DWRSESSIONID=([^;]+)/);
                a && dwr.engine.transport.setDwrSession(a[1])
            }
        },
        xhr: {
            httpMethod: "POST",
            XMLHTTP: ["Msxml2.XMLHTTP.6.0", "Msxml2.XMLHTTP.5.0", "Msxml2.XMLHTTP.4.0", "MSXML2.XMLHTTP.3.0", "MSXML2.XMLHTTP", "Microsoft.XMLHTTP"],
            send: function(a) {
                var b, c, d, e, f;
                a.isPoll && (a.map.partialResponse = dwr.engine._partialResponseYes),
                a.isPoll && "true" == dwr.engine._pollWithXhr && (a.map.partialResponse = dwr.engine._partialResponseNo),
                a.isPoll && dwr.engine.isIE && (a.map.partialResponse = dwr.engine._partialResponseNo),
                window.XMLHttpRequest ? a.req = new XMLHttpRequest: window.ActiveXObject && (a.req = dwr.engine.util.newActiveXObject(dwr.engine.transport.xhr.XMLHTTP)),
                1 == a.async && (a.req.onreadystatechange = function() {
                    "undefined" != typeof dwr && dwr.engine.transport.xhr.stateChange(a)
                }),
                httpMethod = dwr.engine.transport.xhr.httpMethod,
                b = navigator.userAgent.indexOf("Safari/"),
                b >= 0 && (c = navigator.userAgent.substring(b + 7), parseInt(c, 10) < 400 && ("true" == dwr.engine._allowGetForSafariButMakeForgeryEasier ? httpMethod = "GET": dwr.engine._handleWarning(a, {
                    name: "dwr.engine.oldSafari",
                    message: "Safari GET support disabled. See getahead.org/dwr/server/servlet and allowGetForSafariButMakeForgeryEasier."
                }))),
                a.mode = a.isPoll ? dwr.engine._ModePlainPoll: dwr.engine._ModePlainCall,
                d = dwr.engine.batch.constructRequest(a, httpMethod);
                try {
                    a.req.open(httpMethod, d.url, a.async);
                    try {
                        for (e in a.headers) f = a.headers[e],
                        "string" == typeof f && a.req.setRequestHeader(e, f);
                        a.headers["Content-Type"] || a.req.setRequestHeader("Content-Type", "text/plain")
                    } catch(g) {
                        dwr.engine._handleWarning(a, g)
                    }
                    a.req.send(d.body),
                    0 == a.async && dwr.engine.transport.xhr.stateChange(a)
                } catch(g) {
                    dwr.engine._handleError(a, g)
                }
                return a.isPoll && a.map.partialResponse == dwr.engine._partialResponseYes && dwr.engine.transport.xhr.checkCometPoll(),
                a.reply
            },
            stateChange: function(a) {
                var b, c, d, e, f;
                if (a.completed) return dwr.engine._debug("Error: _stateChange() with batch.completed"),
                void 0;
                c = a.req,
                d = 0;
                try {
                    c.readyState >= 2 && (d = c.status)
                } catch(g) {}
                if (! (0 == d && c.readyState < 4) && (200 != d || dwr.engine._pollOnline || dwr.engine._handlePollStatusChange(!0), 4 == c.readyState)) {
                    if (dwr.engine._unloading && !dwr.engine.isJaxerServer) return dwr.engine._debug("Ignoring reply from server as page is unloading."),
                    void 0;
                    try {
                        e = c.responseText,
                        e = dwr.engine._replyRewriteHandler(e),
                        200 != d ? dwr.engine._handleError(a, {
                            name: "dwr.engine.http." + d,
                            message: c.statusText
                        }) : null == e || "" == e ? dwr.engine._handleError(a, {
                            name: "dwr.engine.missingData",
                            message: "No data received from server"
                        }) : (f = c.getResponseHeader("Content-Type"), dwr.engine.isJaxerServer && (f = "text/javascript"), f.match(/^text\/plain/) || f.match(/^text\/javascript/) ? a.isPoll && a.map.partialResponse == dwr.engine._partialResponseYes ? dwr.engine.transport.xhr.processCometResponse(e, a) : -1 == e.search("//#DWR") ? dwr.engine._handleWarning(a, {
                            name: "dwr.engine.invalidReply",
                            message: "Invalid reply from server"
                        }) : b = e: f.match(/^text\/html/) && "function" == typeof a.textHtmlHandler ? a.textHtmlHandler({
                            status: d,
                            responseText: e,
                            contentType: f
                        }) : dwr.engine._handleWarning(a, {
                            name: "dwr.engine.invalidMimeType",
                            message: "Invalid content type: '" + f + "'"
                        }))
                    } catch(h) {
                        dwr.engine._handleWarning(a, h)
                    }
                    dwr.engine._receivedBatch = a,
                    null != b && (b = b.replace(dwr.engine._scriptTagProtection, "")),
                    dwr.engine._eval(b),
                    dwr.engine._receivedBatch = null,
                    dwr.engine.transport.complete(a)
                }
            },
            checkCometPoll: function() {
                var a, b = dwr.engine._pollBatch && dwr.engine._pollBatch.req;
                b && (a = b.responseText, null != a && dwr.engine.transport.xhr.processCometResponse(a, dwr.engine._pollBatch)),
                dwr.engine._pollBatch && setTimeout(dwr.engine.transport.xhr.checkCometPoll, dwr.engine._pollCometInterval)
            },
            processCometResponse: function(a, b) {
                var c, d, e;
                if (b.charsProcessed != a.length) {
                    if (0 == a.length) return b.charsProcessed = 0,
                    void 0;
                    if (c = a.indexOf("//#DWR-START#", b.charsProcessed), -1 == c) return b.charsProcessed = a.length,
                    void 0;
                    if (d = a.lastIndexOf("//#DWR-END#"), -1 != d) {
                        b.charsProcessed = 13 == a.charCodeAt(d + 11) && 10 == a.charCodeAt(d + 12) ? d + 13 : d + 11,
                        e = a.substring(c + 13, d);
                        try {
                            dwr.engine._receivedBatch = b,
                            dwr.engine._eval(e),
                            dwr.engine._receivedBatch = null
                        } catch(f) {
                            null != dwr && dwr.engine._handleError(b, f)
                        }
                    }
                }
            },
            abort: function(a) {
                a.req && a.req.abort()
            },
            remove: function(a) {
                a.req && delete a.req
            }
        },
        iframe: {
            httpMethod: "POST",
            send: function(a) {
                if (null == document.body) return setTimeout(function() {
                    dwr.engine.transport.iframe.send(a)
                },
                100),
                void 0;
                a.httpMethod = dwr.engine.transport.iframe.httpMethod,
                a.fileUpload && (a.httpMethod = "POST", a.encType = "multipart/form-data");
                var b = dwr.engine.transport.iframe.getId(a);
                a.div1 = document.createElement("div"),
                document.body.appendChild(a.div1),
                a.div1.innerHTML = "<iframe src='" + dwr.engine.SSL_SECURE_URL + "' frameborder='0' style='width:0px;height:0px;border:0;display:none;' id='" + b + "' name='" + b + "'></iframe>",
                a.iframe = a.div1.firstChild,
                a.document = document,
                a.iframe.batch = a,
                dwr.engine.transport.iframe.beginLoader(a, b)
            },
            getId: function(a) {
                return a.isPoll ? "dwr-if-poll-" + a.map.batchId: "dwr-if-" + a.map.batchId
            },
            beginLoader: function(a, b) {
                var c, d, e, f, g;
                if (null == a.iframe.contentWindow.document.body) return setTimeout(function() {
                    dwr.engine.transport.iframe.beginLoader(a, b)
                },
                100),
                void 0;
                if (a.isPoll && (a.map.partialResponse = dwr.engine._partialResponseYes), a.mode = a.isPoll ? dwr.engine._ModeHtmlPoll: dwr.engine._ModeHtmlCall, c = dwr.engine.batch.constructRequest(a, a.httpMethod), "GET" == a.httpMethod) a.iframe.setAttribute("src", c.url);
                else {
                    a.div2 = document.createElement("div"),
                    document.body.appendChild(a.div2),
                    a.div2.innerHTML = "<form" + (a.encType ? " encType='" + a.encType + "' encoding='" + a.encType + "'": "") + "></form>",
                    a.form = a.div2.firstChild,
                    a.form.setAttribute("action", c.url),
                    a.form.setAttribute("target", b),
                    a.form.setAttribute("style", "display:none"),
                    a.form.setAttribute("method", a.httpMethod);
                    for (d in a.map) e = a.map[d],
                    "function" != typeof e && (e && e.tagName && "input" == e.tagName.toLowerCase() && e.type && "file" == e.type.toLowerCase() ? (f = e.cloneNode(!0), e.removeAttribute("id", d), e.setAttribute("name", d), e.style.display = "none", e.parentNode.insertBefore(f, e), e.parentNode.removeChild(e), a.form.appendChild(e)) : (g = a.document.createElement("input"), g.setAttribute("type", "hidden"), g.setAttribute("name", d), g.setAttribute("value", e), a.form.appendChild(g)));
                    a.form.submit()
                }
            },
            remote: {
                beginIFrameResponse: function(a) {
                    null != a && (dwr.engine._receivedBatch = a.batch)
                },
                endIFrameResponse: function(a) {
                    dwr.engine._receivedBatch = dwr.engine._batches[a],
                    dwr.engine.transport.complete(dwr.engine._receivedBatch),
                    dwr.engine._receivedBatch = null
                }
            },
            remove: function(a) {
                setTimeout(function() {
                    a.iframe && a.iframe.parentNode && (a.iframe.parentNode.removeChild(a.iframe), a.iframe = null),
                    a.div1 && a.div1.parentNode && (a.div1.parentNode.removeChild(a.div1), a.div1 = null),
                    a.form && a.form.parentNode && (a.form.parentNode.removeChild(a.form), a.form = null),
                    a.div2 && a.div2.parentNode && (a.div2.parentNode.removeChild(a.div2), a.div2 = null)
                },
                100)
            }
        },
        scriptTag: {
            send: function(a) {
                a.isPoll && (a.map.partialResponse = dwr.engine._partialResponseNo),
                a.mode = a.isPoll ? dwr.engine._ModePlainPoll: dwr.engine._ModePlainCall;
                var b = dwr.engine.batch.constructRequest(a, "GET");
                a.script = document.createElement("script"),
                a.script.id = "dwr-st-" + a.map.batchId,
                a.script.src = b.url,
                a.script.type = "text/javascript",
                a.script.async = !0,
                dwr.engine.util.addEventListener(a.script, "load",
                function() {
                    "undefined" != typeof dwr && dwr.engine.transport.scriptTag.complete(a)
                }),
                dwr.engine.util.addEventListener(a.script, "error",
                function() {
                    "undefined" != typeof dwr && dwr.engine.transport.scriptTag.complete(a)
                }),
                dwr.engine.util.addEventListener(a.script, "readystatechange",
                function() {
                    "undefined" != typeof dwr && ("complete" == a.script.readyState || "loaded" == a.script.readyState) && dwr.engine.transport.scriptTag.complete(a)
                }),
                document.getElementsByTagName("head")[0].appendChild(a.script)
            },
            complete: function(a) {
                dwr.engine.transport.complete(a)
            },
            remove: function(a) {
                a.script && (a.script.parentNode.removeChild(a.script), a.script = null)
            }
        },
        htmlfile: {
            send: function(a) {
                var b = dwr.engine.transport.iframe.getId(a);
                a.htmlfile = new window.ActiveXObject("htmlfile"),
                a.htmlfile.open(),
                a.htmlfile.write("<html>"),
                a.htmlfile.write("<div><iframe className='wibble' src='javascript:void(0)' id='" + b + "' name='" + b + "' onload='dwr.engine.transport.iframe.loadingComplete(" + a.map.batchId + ");'></iframe></div>"),
                a.htmlfile.write("</html>"),
                a.htmlfile.close(),
                a.htmlfile.parentWindow.dwr = dwr,
                a.document = a.htmlfile,
                dwr.engine.transport.iframe.beginLoader(a, b)
            }
        }
    },
    dwr.engine.batch = {
        create: function() {
            var a = {
                async: dwr.engine._async,
                charsProcessed: 0,
                handlers: [],
                isPoll: !1,
                map: {
                    callCount: 0,
                    windowName: window.name
                },
                paramCount: 0,
                preHooks: [],
                postHooks: [],
                timeout: dwr.engine._timeout,
                errorHandler: dwr.engine._errorHandler,
                warningHandler: dwr.engine._warningHandler,
                textHtmlHandler: dwr.engine._textHtmlHandler
            };
            return dwr.engine._preHook && a.preHooks.push(dwr.engine._preHook),
            dwr.engine._postHook && a.postHooks.push(dwr.engine._postHook),
            dwr.engine.batch.populateHeadersAndAttributes(a),
            a
        },
        createPoll: function() {
            var a = {
                async: !0,
                charsProcessed: 0,
                handlers: [{
                    callback: function(a) {
                        dwr.engine._pollBatch = null,
                        setTimeout(dwr.engine._poll, a)
                    }
                }],
                isPoll: !0,
                map: {
                    windowName: window.name,
                    callCount: 1
                },
                paramCount: 0,
                path: dwr.engine._pathToDwrServlet,
                preHooks: [],
                postHooks: [],
                timeout: 0,
                windowName: window.name
            };
            return dwr.engine.batch.populateHeadersAndAttributes(a),
            a
        },
        populateHeadersAndAttributes: function(a) {
            var b, c;
            if (a.headers = {},
            dwr.engine._headers) for (b in dwr.engine._headers) c = dwr.engine._headers[b],
            "function" != typeof c && (a.headers[b] = c);
            if (a.attributes = {},
            dwr.engine._attributes) for (b in dwr.engine._attributes) c = dwr.engine._attributes[b],
            "function" != typeof c && (a.attributes[b] = c)
        },
        addCall: function(a, b, c, d) {
            var e, f, g, h, i, j, k = d[d.length - 1];
            for (null == k || "function" == typeof k ? (e = {
                callback: k
            },
            f = d.length - 1) : "object" != typeof k || "function" != typeof k.callback && "function" != typeof k.exceptionHandler && "function" != typeof k.callbackHandler && "function" != typeof k.errorHandler && "function" != typeof k.warningHandler ? (e = {},
            f = d.length) : (e = k, f = d.length - 1), dwr.engine.batch.merge(a, e), a.handlers[a.map.callCount] = {
                exceptionHandler: e.exceptionHandler,
                exceptionArg: e.exceptionArg || e.arg || null,
                exceptionScope: e.exceptionScope || e.scope || window,
                callback: e.callbackHandler || e.callback,
                callbackArg: e.callbackArg || e.arg || null,
                callbackScope: e.callbackScope || e.scope || window
            },
            g = "c" + a.map.callCount + "-", a.map[g + "scriptName"] = b, a.map[g + "methodName"] = c, a.map[g + "id"] = a.map.callCount, h = {},
            i = {},
            j = 0; f > j; j++) dwr.engine.serialize.convert(a, h, i, d[j], g + "param" + j, 0);
            dwr.engine.serialize.cleanup(h)
        },
        merge: function(a, b) {
            var c, d, e, f;
            for (e = 0; e < dwr.engine._propnames.length; e++) c = dwr.engine._propnames[e],
            null != b[c] && (a[c] = b[c]);
            if (null != b.preHook && a.preHooks.unshift(b.preHook), null != b.postHook && a.postHooks.push(b.postHook), b.headers) for (c in b.headers) d = b.headers[c],
            "function" != typeof d && (a.headers[c] = d);
            if (f = null, b.attributes && (f = b.attributes), f) for (c in f) d = f[c],
            "function" != typeof d && (a.attributes[c] = d)
        },
        prepareToSend: function(a) {
            a.map.batchId = dwr.engine._nextBatchId,
            dwr.engine._nextBatchId++,
            dwr.engine._batches[a.map.batchId] = a,
            dwr.engine._batchesLength++,
            a.completed = !1,
            a.map.instanceId = dwr.engine._instanceId,
            a.map.page = encodeURIComponent(window.location.pathname + window.location.search),
            a.map.scriptSessionId = dwr.engine._scriptSessionId,
            a.map.windowName = window.name;
            for (var b = 0; b < a.preHooks.length; b++) a.preHooks[b]();
            a.preHooks = null,
            a.timeout && 0 != a.timeout && (a.timeoutId = setTimeout(function() {
                dwr.engine.transport.abort(a)
            },
            a.timeout))
        },
        constructRequest: function(a, b) {
            var c, d, e, f, g, h, i, j = [];
            if (j.push(a.path), j.push(a.mode), a.isPoll ? j.push("ReverseAjax.dwr") : 1 == a.map.callCount ? (j.push(a.map["c0-scriptName"]), j.push("."), j.push(a.map["c0-methodName"]), j.push(".dwr")) : (j.push("Multiple."), j.push(a.map.callCount), j.push(".dwr")), c = new RegExp("^[^;\\?#]+(;[^\\?#]+)"), d = location.href.match(c), null != d && j.push(d[1]), a.attributes) for (e in a.attributes) f = a.attributes[e],
            "function" != typeof f && (a.map["a-" + e] = "" + f);
            if (g = {},
            "GET" == b) {
                a.map.callCount = "" + a.map.callCount,
                j.push("?");
                for (h in a.map)"function" != typeof a.map[h] && (j.push(encodeURIComponent(h)), j.push("="), j.push(encodeURIComponent(a.map[h])), j.push("&"));
                j.pop(),
                g.body = null
            } else {
                if (g.body = "", dwr.engine.isIE <= 7) {
                    i = [];
                    for (h in a.map)"function" != typeof a.map[h] && i.push(h + "=" + a.map[h] + dwr.engine._postSeperator);
                    g.body = i.join("")
                } else for (h in a.map)"function" != typeof a.map[h] && (g.body += h + "=" + a.map[h] + dwr.engine._postSeperator);
                g.body = dwr.engine._contentRewriteHandler(g.body)
            }
            return g.url = dwr.engine._urlRewriteHandler(j.join("")),
            g
        },
        validate: function(a) {
            if (!a.completed) for (var b = 0; b < a.map.callCount; b++) if (a.handlers[b].completed !== !0) {
                dwr.engine._handleError(a, {
                    name: "dwr.engine.incompleteReply",
                    message: "Incomplete reply from server"
                });
                break
            }
        },
        remove: function(a) {
            if (!a) return dwr.engine._debug("Warning: null batch in dwr.engine.batch.remove()", !0),
            void 0;
            if (!a.completed && (a.completed = !0, dwr.engine.transport.remove(a), null != a.timeoutId && (clearTimeout(a.timeoutId), delete a.timeoutId), a.map && (a.map.batchId || 0 == a.map.batchId) && (delete dwr.engine._batches[a.map.batchId], dwr.engine._batchesLength--), 0 != dwr.engine._batchQueue.length)) {
                var b = dwr.engine._batchQueue.shift();
                dwr.engine.transport.send(b)
            }
        }
    },
    dwr.engine.util = {
        newActiveXObject: function(a) {
            var b, c;
            for (c = 0; c < a.length; c++) try {
                b = new ActiveXObject(a[c]);
                break
            } catch(d) {}
            return b
        },
        tokenify: function(a) {
            for (var b = [], c = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ*$", d = a; d > 0;) b.push(c.charAt(63 & d)),
            d = Math.floor(d / 64);
            return b.join("")
        },
        addEventListener: function(a, b, c) {
            a.addEventListener ? a.addEventListener(b, c, !1) : a.attachEvent("on" + b, c)
        }
    },
    userAgent = navigator.userAgent,
    versionString = navigator.appVersion,
    version = parseFloat(versionString),
    dwr.engine.isOpera = userAgent.indexOf("Opera") >= 0 ? version: 0,
    dwr.engine.isKhtml = versionString.indexOf("Konqueror") >= 0 || versionString.indexOf("Safari") >= 0 ? version: 0,
    dwr.engine.isSafari = versionString.indexOf("Safari") >= 0 ? version: 0,
    dwr.engine.isJaxerServer = window.Jaxer && Jaxer.isOnServer,
    geckoPos = userAgent.indexOf("Gecko"),
    dwr.engine.isMozilla = geckoPos >= 0 && !dwr.engine.isKhtml ? version: 0,
    dwr.engine.isFF = 0,
    dwr.engine.isIE = 0;
    try {
        dwr.engine.isMozilla && (dwr.engine.isFF = parseFloat(userAgent.split("Firefox/")[1].split(" ")[0])),
        document.all && !dwr.engine.isOpera && (dwr.engine.isIE = parseFloat(versionString.split("MSIE ")[1].split(";")[0]))
    } catch(ex) {}
    dwr.engine._pageId = dwr.engine.util.tokenify((new Date).getTime()) + "-" + dwr.engine.util.tokenify(1e16 * Math.random()),
    dwr.engine.transport.updateDwrSessionFromCookie(),
    dwr.engine.isJaxerServer || dwr.engine.util.addEventListener(window, "unload", dwr.engine._unloader),
    g = dwr.engine._global,
    g.dwr || (g.dwr = {}),
    g.dwr._ || (g.dwr._ = []),
    dwr.engine._instanceId = g.dwr._.length,
    g.dwr._[dwr.engine._instanceId] = {
        handleCallback: dwr.engine.remote.handleCallback,
        handleException: dwr.engine.remote.handleException,
        handleNewWindowName: dwr.engine.remote.handleNewWindowName,
        handleBatchException: dwr.engine.remote.handleBatchException,
        handleFunctionCall: dwr.engine.remote.handleFunctionCall,
        handleObjectCall: dwr.engine.remote.handleObjectCall,
        handleSetCall: dwr.engine.remote.handleSetCall,
        handleFunctionClose: dwr.engine.remote.handleFunctionClose,
        handleObjectCall: dwr.engine.remote.handleObjectCall,
        handleForeign: dwr.engine.remote.handleForeign,
        pollCometDisabled: dwr.engine.remote.pollCometDisabled,
        newObject: dwr.engine.remote.newObject,
        toDomElement: dwr.engine.serialize.toDomElement,
        toDomDocument: dwr.engine.serialize.toDomDocument,
        beginIFrameResponse: dwr.engine.transport.iframe.remote.beginIFrameResponse,
        endIFrameResponse: dwr.engine.transport.iframe.remote.endIFrameResponse,
        _eval: dwr.engine._eval
    },
    eval("dwr.engine._execute(dwr.engine._pathToDwrServlet, '__System', 'pageLoaded', [ function() { dwr.engine._ordered = false; }]);"),
    dwr.hub = {
        publish: function(a, b) {
            dwr.engine._execute(dwr.engine._pathToDwrServlet, "__System", "publish", a, b, {})
        },
        subscribe: function(a, b, c, d) {
            var e = "" + dwr.hub._subscriptionId;
            return dwr.hub._subscriptionId++,
            dwr.hub._subscriptions[e] = {
                callback: b,
                scope: c,
                subscriberData: d
            },
            dwr.engine._execute(dwr.engine._pathToDwrServlet, "__System", "subscribe", a, e, {}),
            e
        },
        _remotePublish: function(a, b) {
            var c = dwr.hub._subscriptions[a];
            c && c.callback.call(c.scope, b, c.subscriberData)
        },
        _subscriptionId: 0,
        _subscriptions: {}
    },
    dwr.data = {
        StoreChangeListener: {
            itemRemoved: function() {},
            itemAdded: function() {},
            itemChanged: function() {}
        },
        Cache: function(a, b) {
            this.storeId = a,
            this.listener = b
        }
    },
    dwr.data.Cache.prototype.viewRegion = function(a, b) {
        if (a || (a = {}), a.start || (a.start = 0), a.count || (a.count = -1), a.sort) for (var c = 0; c < a.sort.length; c++)"undefined" == typeof a.sort[c].descending && (a.sort[c].descending = !1);
        else a.sort = [];
        return a.query || (a.query = {}),
        dwr.engine._execute(dwr.engine._pathToDwrServlet, "__Data", "viewRegion", [this.storeId, a, this.listener, b])
    },
    dwr.data.Cache.prototype.viewItem = function(a, b) {
        return dwr.engine._execute(dwr.engine._pathToDwrServlet, "__Data", "viewItem", [this.storeId, a, this.listener, b])
    },
    dwr.data.Cache.prototype.unsubscribe = function(a) {
        return this.listener ? dwr.engine._execute(dwr.engine._pathToDwrServlet, "__Data", "unsubscribe", [this.storeId, this.listener, a]) : void 0
    },
    dwr.data.Cache.prototype.update = function(a, b) {
        return dwr.engine._execute(dwr.engine._pathToDwrServlet, "__Data", "update", [this.storeId, a, b])
    }
} (),
selectRow = null,
pageMap = null,
_pageSize_ = 15,
String.prototype.replaceAll = function(a, b, c) {
    return RegExp.prototype.isPrototypeOf(a) ? this.replace(a, b) : this.replace(new RegExp(a, c ? "gi": "g"), b)
},
$(function() {
    initValidate(!0),
    $("#main_home").length > 0 && ($(".menu_type ul li").hover(function() {
        $(".menu_typebox").fadeIn();
        var a = $(this).index(".menu_type ul li");
        $(this).addClass("bodyOne").siblings().removeClass("bodyOne"),
        $($(".menu_type_list")[a]).show().siblings().hide()
    }), $(".main_l").mouseleave(function() {
        $(".menu_typebox").fadeOut(),
        $(".menu_type_list").fadeOut(),
        $(".typelistbox").fadeOut(),
        $(".menu_type ul li").removeClass("bodyOne")
    }), $(".menu_type_list ul li").hover(function() {
        $(this).fadeIn();
        var a = $(this).index(".menu_type_list ul li");
        $(".typelistbox").hide(),
        $($(".typelistbox")[a]).show()
    })),
    $("#pageDiv").length > 0 && $("#pageDiv").pagination({
        onSelectPage: function(a) {
            var d, e, c = new Object;
            getRequestParameter(c, window.location.search),
            c["ptotal"] = $("#pageDiv").attr("total"),
            c["pnum"] = a,
            d = "",
            e = !0;
            for (k in c) e || (d += "&"),
            d = d + k + "=" + c[k],
            e = !1;
            window.location = location.pathname + "?" + d
        }
    })
}),
dwr.engine._errorHandler = function(a, b) {
    if (void 0 != b.javaClassName && null != b.javaClassName) {
        if (b.javaClassName.indexOf("AdminLogonException") > 0) return window.location = getContextPath() + "admin.jsp",
        void 0;
        if (b.javaClassName.indexOf("ForegLogonException") > 0) return window.location = getContextPath() + "index.jsp",
        void 0;
        if (b.javaClassName.indexOf("PowerException") > 0) return window.location = getContextPath() + "power.jsp",
        void 0
    }
    msgbox(a.replaceAll("java.lang.Exception:", "", !0))
},
footer_data = null;
var buttons = $.extend([], $.fn.datebox.defaults.buttons);
buttons.splice(1, 0, {
    text: "清空",
    handler: function(a) {
        $(a).combo("setValue", "").combo("setText", ""),
        $(a).combo("hidePanel")
    }
}),
$.fn.datebox.defaults.buttons = buttons,
$.fn.pagination && ($.fn.pagination.defaults.beforePageText = "第", $.fn.pagination.defaults.afterPageText = "共{pages}页", $.fn.pagination.defaults.displayMsg = "显示{from}到{to}条，共{total}条记录"),
$.fn.datagrid && ($.fn.datagrid.defaults.loadMsg = "正在处理，请稍待。。。"),
$.fn.treegrid && $.fn.datagrid && ($.fn.treegrid.defaults.loadMsg = $.fn.datagrid.defaults.loadMsg),
$.messager && ($.messager.defaults.ok = "确定", $.messager.defaults.cancel = "取消"),
$.map(["validatebox", "textbox", "filebox", "searchbox", "combo", "combobox", "combogrid", "combotree", "datebox", "datetimebox", "numberbox", "spinner", "numberspinner", "timespinner", "datetimespinner"],
function(a) {
    $.fn[a] && ($.fn[a].defaults.missingMessage = "该输入项为必输项")
}),
$.fn.validatebox && ($.fn.validatebox.defaults.rules.email.message = "请输入有效的电子邮件地址", $.fn.validatebox.defaults.rules.url.message = "请输入有效的URL地址", $.fn.validatebox.defaults.rules.length.message = "输入内容长度必须介于{0}和{1}之间", $.fn.validatebox.defaults.rules.remote.message = "请修正该字段"),
$.fn.calendar && ($.fn.calendar.defaults.weeks = ["日", "一", "二", "三", "四", "五", "六"], $.fn.calendar.defaults.months = ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"]),
$.fn.datebox && ($.fn.datebox.defaults.currentText = "今天", $.fn.datebox.defaults.closeText = "关闭", $.fn.datebox.defaults.okText = "确定", $.fn.datebox.defaults.formatter = function(a) {
    var b = a.getFullYear(),
    c = a.getMonth() + 1,
    d = a.getDate();
    return b + "-" + (10 > c ? "0" + c: c) + "-" + (10 > d ? "0" + d: d)
},
$.fn.datebox.defaults.parser = function(a) {
    var b, c, d, e;
    return a ? (b = a.split("-"), c = parseInt(b[0], 10), d = parseInt(b[1], 10), e = parseInt(b[2], 10), isNaN(c) || isNaN(d) || isNaN(e) ? new Date: new Date(c, d - 1, e)) : new Date
}),
$.fn.datetimebox && $.fn.datebox && $.extend($.fn.datetimebox.defaults, {
    currentText: $.fn.datebox.defaults.currentText,
    closeText: $.fn.datebox.defaults.closeText,
    okText: $.fn.datebox.defaults.okText
}),
$.fn.datetimespinner && ($.fn.datetimespinner.defaults.selections = [[0, 4], [5, 7], [8, 10], [11, 13], [14, 16], [17, 19]]),
MsgSupport.genProgress = function() {
    var a = "<input style='BACKGROUND: #fff; BORDER: 1px solid; HEIGHT: 8px; MARGIN: 3px; WIDTH: 8px'>",
    b = "";
    for (i = 0; 5 > i; i++) b += a;
    return b
},
MsgSupport.p = 0,
MsgSupport.j = 0,
MsgSupport.stop = !1,
MsgSupport.c = new Array("Aqua", "white"),
MsgSupport.flashID = 0,
MsgSupport.flashs = function() {
    MsgSupport.flashID = 0;
    var a = document.getElementById("myDisabledZone");
    "visible" == a.style.visibility && (document.getElementById("progressForm").elements[MsgSupport.p].style.background = MsgSupport.c[MsgSupport.j], MsgSupport.p += 1, 5 == MsgSupport.p && (MsgSupport.p = 0, MsgSupport.j = 1 - MsgSupport.j), MsgSupport.flashID = window.setTimeout("MsgSupport.flashs();", 100))
},
MsgSupport.openMessage = function() {
    var a, b;
    MsgSupport.message = "加载中...",
    window.status = MsgSupport.message,
    a = document.getElementById("myDisabledZone"),
    null == a && (a = document.createElement("div"), a.setAttribute("id", "myDisabledZone"), a.style.position = "absolute", a.style.zIndex = "1000", a.style.left = "0px", a.style.top = "0px", a.style.width = "100%", a.style.height = "100%", document.body.appendChild(a), b = document.createElement("div"), b.setAttribute("id", "myMessageZone"), b.style.position = "absolute", b.style.top = "0px", b.style.right = "0px", b.style.color = "black", b.style.fontFamily = "Arial,Helvetica,sans-serif", b.style.fontSize = "13", b.style.padding = "2px", a.appendChild(b), b.innerHTML = "<form id=progressForm name=progressForm><table border=0 height=30 cellpadding=2 cellspacing=1><tr><td>" + MsgSupport.genProgress() + "</td></tr></table></FORM>"),
    "visible" != a.style.visibility && (a.style.visibility = "visible", MsgSupport.flashID = window.setTimeout("MsgSupport.flashs();", 100))
},
MsgSupport.closeMessage = function() {
    var a = document.getElementById("myDisabledZone");
    null != a && (a.style.visibility = "hidden"),
    MsgSupport.flashID > 0 && clearTimeout(MsgSupport.flashID),
    MsgSupport.stop = !0
},
dwr.engine.setPreHook(function() {
    MsgSupport.openMessage()
}),
dwr.engine.setPostHook(function() {
    MsgSupport.stop = !1,
    MsgSupport.closeMessage()
}),
$.extend($.fn.validatebox.defaults.rules, {
    CHS: {
        validator: function(a) {
            return /^[\u0391-\uFFE5]+$/.test(a)
        },
        message: "只能输入汉字"
    },
    mobile: {
        validator: function(a) {
            var b = /^1[3|4|5|7|8|9]\d{9}$/;
            return b.test(a)
        },
        message: "输入手机号码格式不准确."
    },
    zipcode: {
        validator: function(a) {
            var b = /^[1-9]\d{5}$/;
            return b.test(a)
        },
        message: "邮编必须是非0开始的6位数字."
    },
    account: {
        validator: function(a, b) {
            return a.length < b[0] || a.length > b[1] ? ($.fn.validatebox.defaults.rules.account.message = "用户账号长度必须在" + b[0] + "至" + b[1] + "范围", !1) : /^[\w]+$/.test(a) ? !0 : ($.fn.validatebox.defaults.rules.account.message = "用户名只能数字、字母、下划线组成.", !1)
        },
        message: ""
    }
}),
$.extend($.fn.validatebox.defaults.rules, {
    idcard: {
        validator: function(a) {
            return /^\d{15}(\d{2}[A-Za-z0-9])?$/i.test(a)
        },
        message: "身份证号码格式不正确"
    },
    intOrFloat: {
        validator: function(a) {
            return /^\d+(\.\d+)?$/i.test(a)
        },
        message: "请输入数字，并确保格式正确"
    }
}),
$.extend($.fn.validatebox.defaults.rules, {
    phone: {
        validator: function(a) {
            var b = /^1[3-8]+\d{9}$/,
            c = /^((0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$/;
            return b.test(a) || c.test(a) ? !0 : !1
        },
        message: "请输入正确电话或手机格式"
    }
}),
$(function() {
    $("input.easyui-validatebox").validatebox({
        tipOptions: {
            showEvent: "mouseenter",
            hideEvent: "mouseleave",
            showDelay: 0,
            hideDelay: 0,
            zIndex: "",
            onShow: function() {
                $(this).hasClass("validatebox-invalid") ? $(this).tooltip("tip").css({
                    color: "#000",
                    borderColor: "#CC9933",
                    backgroundColor: "#FFFFCC"
                }) : $(this).tooltip("options").prompt ? $(this).tooltip("update", $(this).tooltip("options").prompt) : $(this).tooltip("tip").hide()
            },
            onHide: function() {
                $(this).tooltip("options").prompt || $(this).tooltip("destroy")
            }
        }
    }).tooltip({
        position: "right",
        content: function() {
            var a = $(this).validatebox("options");
            return a.prompt
        },
        onShow: function() {
            $(this).tooltip("tip").css({
                color: "#000",
                borderColor: "#CC9933",
                backgroundColor: "#FFFFCC"
            })
        }
    })
});

DFSDOMAIN = "http://192.168.0.253/";