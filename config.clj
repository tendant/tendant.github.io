[:site-title "blog.leiwang.info"
 :emacs "/usr/bin/emacs"
 :site-description "blog.leiwang.info"
 :site-url "http://blog.leiwang.info"
 :in-dir "resources/"
 :out-dir "html/"
 :default-template "default.clj"
 :encoding "UTF-8"
 :blog-as-index false
 :create-archives false
 :org-export-command (progn
                      (setq org-export-with-toc nil)
                      (org-html-export-as-html nil nil nil t nil)
                      (switch-to-buffer "*Org HTML Export*")
                      (princ (buffer-string)))
 :emacs-eval ['(set-language-environment 'Chinese-GB)
              '(setq locale-coding-system 'utf-8)
              '(set-terminal-coding-system 'utf-8)
              '(set-keyboard-coding-system 'utf-8)
              '(set-selection-coding-system 'utf-8)
              '(prefer-coding-system 'utf-8)
              '(require 'un-define "un-define" t)
              '(set-buffer-file-coding-system 'utf-8 'utf-8-unix)
              '(set-default buffer-file-coding-system 'utf-8-unix)
              '(set-default-coding-systems 'utf-8-unix)
              '(prefer-coding-system 'utf-8-unix)
              '(set-default default-buffer-file-coding-system 'utf-8-unix)
              '(defadvice org-html-paragraph (before fsh-org-html-paragraph-advice
                                      (paragraph contents info) activate)
  "Join consecutive Chinese lines into a single long line without
unwanted space when exporting org-mode to html."
  (let ((fixed-contents)
        (orig-contents (ad-get-arg 1))
        (reg-han "[[:multibyte:]]"))
    (setq fixed-contents (replace-regexp-in-string
                          ;; 这一行是匹配上一行末和下一行头都是中文的情况, 但是这样的话遇上"中文\nenglish"就仍然有空格
                          ;; (concat "\\(" reg-han "\\) *\n *\\(" reg-han "\\)")
                          (concat "\\(" reg-han "\\) *\n *")
                          "\\1" orig-contents))
    (ad-set-arg 1 fixed-contents)))]
 :atomic-build true]

